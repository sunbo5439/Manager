package cn.pku.meizi.controller;

import com.google.gson.JsonObject;
import net.sf.json.JSONArray;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.lightcouch.DesignDocument;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by hadoop on 2016/7/10.
 */
@Controller
public class StatisticController {

    private String username = "root";
    private String password = "pkulky201";
    String upload_log_url="jdbc:mysql://localhost:3306/upload_log";
    String tps_url="jdbc:mysql://localhost:3306/tps";;

    @RequestMapping("program_statistics")
    public String programStatistic(Model model) {
        CouchDbProperties properties = new CouchDbProperties()
                .setDbName("program")
                .setCreateDbIfNotExist(false)
                .setProtocol("http")
                .setHost("162.105.180.15")
                .setPort(5984);
        CouchDbClient dbClient = new CouchDbClient(properties);

        DesignDocument.MapReduce mapReduce = new DesignDocument.MapReduce();
        mapReduce.setMap("function(doc){\n" +
                "  var copyrightowner = doc.Metadata.Program.Copyright.NameofCopyrightOwner;\n" +
                "  if(copyrightowner != null && copyrightowner != \"\"){\n" +
                "    emit(copyrightowner, 1);\n" +
                "  }\n" +
                "}");
        mapReduce.setReduce("function(keys, values) {return sum(values);}");

        DesignDocument.MapReduce mapReduce2 = new DesignDocument.MapReduce();
        mapReduce2.setMap("function(doc){\n" +
                "  var programType = doc.Metadata.Program.Type.ProgramType;\n" +
                "  if(programType != null && programType != \"\"){\n" +
                "    emit(programType, 1);\n" +
                "  }\n" +
                "}");
        mapReduce2.setReduce("function(keys, values) {return sum(values);}");

        DesignDocument.MapReduce mapReduce3 = new DesignDocument.MapReduce();
        mapReduce3.setMap("function(doc) {\n" +
                "  var source = doc.Metadata.Program.Source. AcquiringMethodofSource;\n" +
                "  emit(source, 1);\n" +
                "}");
        mapReduce3.setReduce("_sum");

        List<JsonObject> list_one = dbClient.view("_temp_view").tempView(mapReduce).reduce(true).groupLevel(new Integer(1)).query(JsonObject.class);
        Iterator<JsonObject> iterator = list_one.iterator();
        JSONArray tvStationStatistic = new JSONArray();
        JSONArray tvStationStatistic1 = new JSONArray();
        JSONArray tvStationStatistic2 = new JSONArray();
        while (iterator.hasNext()) {
            JsonObject object = iterator.next();
            tvStationStatistic1.add(object.get("key").toString().split("\"")[1]);
            tvStationStatistic2.add(object.get("value").toString());
        }

        List<JsonObject> list_two = dbClient.view("_temp_view").tempView(mapReduce2).reduce(true).groupLevel(new Integer(1)).query(JsonObject.class);
        Iterator<JsonObject> iterator2 = list_two.iterator();
        JSONArray typeStatistic = new JSONArray();
        JSONArray typeStatistic1 = new JSONArray();
        JSONArray typeStatistic2 = new JSONArray();
        while (iterator2.hasNext()) {
            JsonObject object = iterator2.next();
            typeStatistic1.add(object.get("key").toString().split("\"")[1]);
            typeStatistic2.add(object.get("value").toString());
        }

        List<JsonObject> list_three = dbClient.view("_temp_view").tempView(mapReduce3).reduce(true).groupLevel(new Integer(1)).query(JsonObject.class);
        Iterator<JsonObject> iterator3 = list_three.iterator();
        JSONArray sourceStatistic = new JSONArray();
        JSONArray sourceStatistic1 = new JSONArray();
        JSONArray sourceStatistic2 = new JSONArray();
        while (iterator3.hasNext()) {
            JsonObject object = iterator3.next();
            sourceStatistic1.add(object.get("key").toString().split("\"")[1]);
            sourceStatistic2.add(object.get("value").toString());
        }

        tvStationStatistic.add(tvStationStatistic1);
        tvStationStatistic.add(tvStationStatistic2);
        model.addAttribute("tvStationStatistic", tvStationStatistic);

        typeStatistic.add(typeStatistic1);
        typeStatistic.add(typeStatistic2);
        model.addAttribute("typeStatistic", typeStatistic);

        sourceStatistic.add(sourceStatistic1);
        sourceStatistic.add(sourceStatistic2);
        model.addAttribute("sourceStatistic", sourceStatistic);

        return "programStatistic";
    }


    @RequestMapping("upload_statistics")
    public String uploadStatistic (Model model){
        Connection connection = null;
        String sql;
        String url = upload_log_url;
        String count;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            JSONArray totalStatistic = new JSONArray();
            sql = "select count(*) from upload_log";
            ResultSet resultSet_four = statement.executeQuery(sql);
            JSONArray totalStatistic1 = new JSONArray();
            JSONArray totalStatistic2 = new JSONArray();
            if (resultSet_four.next()) {
                totalStatistic1.add("总视频数");
                totalStatistic2.add(resultSet_four.getInt(1));
            }

            JSONArray copyrightStatistic = new JSONArray();
            sql = "select video_copyright, count(video_copyright) from upload_log group by video_copyright;";
            ResultSet resultSet = statement.executeQuery(sql);
            JSONArray copyrightStatistic1 = new JSONArray();
            JSONArray copyrightStatistic2 = new JSONArray();
            while (resultSet.next()) {
                copyrightStatistic1.add(resultSet.getString(1));
                copyrightStatistic2.add(resultSet.getString(2));
            }

            JSONArray userStatistic = new JSONArray();
            sql = "select uploader_name, count(uploader_name) from upload_log group by uploader_name";
            ResultSet resultSet_two = statement.executeQuery(sql);
            JSONArray userStatistic1 = new JSONArray();
            JSONArray userStatistic2 = new JSONArray();
            while (resultSet_two.next()) {
                userStatistic1.add(resultSet_two.getString(1));
                userStatistic2.add(resultSet_two.getString(2));
            }


            JSONArray timeStatistic = new JSONArray();
            sql = "select date_format(upload_time, '%Y'), count(*) from upload_log group by date_format(upload_time, '%Y')";
            ResultSet resultSet_three = statement.executeQuery(sql);
            JSONArray timeStatistic1 = new JSONArray();
            JSONArray timeStatistic2 = new JSONArray();
            while (resultSet_three.next()) {
                timeStatistic1.add(resultSet_three.getString(1));
                timeStatistic2.add(resultSet_three.getString(2));
            }

            totalStatistic.add(totalStatistic1);
            totalStatistic.add(totalStatistic2);
            model.addAttribute("totalStatistic", totalStatistic);

            copyrightStatistic.add(copyrightStatistic1);
            copyrightStatistic.add(copyrightStatistic2);
            model.addAttribute("copyrightStatistic", copyrightStatistic);

            userStatistic.add(userStatistic1);
            userStatistic.add(userStatistic2);
            model.addAttribute("userStatistic", userStatistic);

            timeStatistic.add(timeStatistic1);
            timeStatistic.add(timeStatistic2);
            model.addAttribute("timeStatistic", timeStatistic);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return "uploadStatistic";
    }

    @RequestMapping("download_statistics")
    public String downloadStatistic (Model model){
        Connection connection = null;
        String sql;
        String url = tps_url;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            JSONArray totalDownload = new JSONArray();
            JSONArray totalDownload1 = new JSONArray();
            JSONArray totalDownload2 = new JSONArray();

            sql = "select sum(down_count) from order_item_segment";
            ResultSet resultSet_four = statement.executeQuery(sql);
            if (resultSet_four.next()) {
                totalDownload1.add("总视频数");
                totalDownload2.add(resultSet_four.getInt(1));
            }

            totalDownload.add(totalDownload1);
            totalDownload.add(totalDownload2);

            JSONArray totalMoney = new JSONArray();
            JSONArray totalMoney1 = new JSONArray();
            JSONArray totalMoney2 = new JSONArray();

            sql = "select sum(price*down_count) from (order_item inner join order_item_segment on order_item.id = order_item_segment.order_item_id);";
            ResultSet resultSet_five = statement.executeQuery(sql);
            if (resultSet_five.next()) {
                totalMoney1.add("金额");
                totalMoney2.add(resultSet_five.getDouble(1));
            }

            totalMoney.add(totalMoney1);
            totalMoney.add(totalMoney2);

//            JSONArray sourceStatistic = new JSONArray();
//            JSONArray sourceStatistic1 = new JSONArray();
//            JSONArray sourceStatistic2 = new JSONArray();
//
//            sql = "select raw_from, sum(down_count)\n" +
//                    "from order_item_segment,sub_media,raw_media\n" +
//                    "where order_item_segment.sub_media_id=sub_media.id && sub_media.raw_id=raw_media.id\n" +
//                    "group by raw_from;";
//            ResultSet resultSet_six = statement.executeQuery(sql);
//            while (resultSet_six.next()) {
//                sourceStatistic1.add(resultSet_six.getString(1));
//                sourceStatistic2.add(resultSet_six.getString(2));
//            }

//            sourceStatistic.add(sourceStatistic1);
//            sourceStatistic.add(sourceStatistic2);

            model.addAttribute("totalDownload", totalDownload);
            model.addAttribute("totalMoney", totalMoney);
//            model.addAttribute("sourceStatistic", sourceStatistic);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "downloadStatistic";
    }

    @RequestMapping("catalog_statistics")
    public String catalogStatistic (Model model) {
        CouchDbProperties properties = new CouchDbProperties()
                .setDbName("program")
                .setCreateDbIfNotExist(false)
                .setProtocol("http")
                .setHost("162.105.16.84")
                .setPort(5984);
        CouchDbClient dbClient = new CouchDbClient(properties);

        DesignDocument.MapReduce mapReduce = new DesignDocument.MapReduce();
        mapReduce.setMap("function(doc) {\n" +
                "  var time = doc.Metadata. UploadTime.substring(0,4);\n" +
                "  emit(time, 1);\n" +
                "}");
        mapReduce.setReduce("_sum");

        List<JsonObject> list_one = dbClient.view("_temp_view").tempView(mapReduce).reduce(true).groupLevel(new Integer(1)).query(JsonObject.class);
        Iterator<JsonObject> iterator = list_one.iterator();
        JSONArray catalogTimeStatistic = new JSONArray();
        JSONArray catalogTimeStatistic1 = new JSONArray();
        JSONArray catalogTimeStatistic2 = new JSONArray();
        while (iterator.hasNext()) {
            JsonObject object = iterator.next();
            catalogTimeStatistic1.add(object.get("key").toString().split("\"")[1]);
            catalogTimeStatistic2.add(object.get("value").toString());
        }

        catalogTimeStatistic.add(catalogTimeStatistic1);
        catalogTimeStatistic.add(catalogTimeStatistic2);

        model.addAttribute("catalogTimeStatistic", catalogTimeStatistic);

        return "catalogStatistic";
    }
}

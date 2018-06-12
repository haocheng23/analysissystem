package com.haocheng.analysissystem.util;

import com.alibaba.fastjson.JSONObject;

import java.io.*;

/**
 * 准备数据
 */
public class txt2csv {
    /**
     * json数据预处理
     * @param srcpath   txt路径
     * @param midpath   csv路径
     * @return
     */
    public static void prehandle(String srcpath, String midpath){
        BufferedReader br = null;
        BufferedWriter bw = null;
        String str = "";
        try {
            br = new BufferedReader(new FileReader(srcpath));
            bw = new BufferedWriter(new FileWriter(midpath));
            String line = null;
            bw.write("calltime,"+"messagenum,"+"flow"+"\r\n");
            while((line=br.readLine())!=null){
//                System.out.println(line);
                JSONObject obj = JSONObject.parseObject(line);
                Integer calltime = Integer.valueOf(obj.getString("calltime"));
                Integer messagenum = Integer.valueOf(obj.getString("messagenum"));
                Integer flow = Integer.valueOf(obj.getString("flow"));

                str = calltime + "," + messagenum + "," + flow;
                bw.write(str);
                bw.flush();
                bw.newLine();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

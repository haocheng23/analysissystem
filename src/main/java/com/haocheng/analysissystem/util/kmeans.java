package com.haocheng.analysissystem.util;

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.DistanceFunction;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ArffLoader;
import weka.core.converters.DatabaseLoader;
import weka.core.converters.DatabaseSaver;
import weka.experiment.InstanceQuery;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class kmeans {
    public static List exec() {
        Instances ins = null;
        SimpleKMeans KM = null;
        ClusterEvaluation eval = null;
        ArrayList lists = null;
        try {
            /**
             * 读取mysql作为数据源
             */
            DatabaseLoader dloader = new DatabaseLoader();
            String url = "jdbc:mysql://127.0.0.1:3306/bysj";
            String user = "root";
            String pass = "123456";
            dloader.setSource(url, user, pass);
            dloader.setQuery("SELECT calltime,messagenum,flow FROM res_bill");
            //批量检索
            Instances dataSet = dloader.getDataSet();

            // 初始化聚类器 （加载算法）
            KM = new SimpleKMeans();
            KM.setNumClusters(3);       //设置聚类要得到的类别数量
            KM.setSeed(10);
            KM.buildClusterer(dataSet);     //开始进行聚类

//          System.out.println(KM.preserveInstancesOrderTipText());

            //簇信息
            Instances instances = KM.getClusterCentroids();
            System.out.println("Centroids:" + instances);
            System.out.println("*********************");


            //数据源信息
            lists = new ArrayList();
            //遍历所有的instances
            for (int i = 0; i < instances.numAttributes(); i++) {
                ArrayList list = new ArrayList();
                /*获取到当前索引处的instance*/
                Instance instance = instances.get(i);
                System.out.println(instances.numAttributes());
                /*遍历instances中的instance*/
                for (int j = 0; j < instance.numAttributes(); j++) {
//                    每一簇的值
                    list.add(instance.value(j));
                    System.out.println(list);
                }

                /*将instances中的每个instance添加到集合中*/
                lists.add(list);
            }

            System.out.println("*********************");
            /*每个instance所对应的簇*/
            ArrayList listdata = new ArrayList();
            for (int k = 0; k < dataSet.numInstances(); k++) {
                int cluster = KM.clusterInstance(dataSet.instance(k));
                String s = dataSet.instance(k).toString();
                listdata.add(cluster + ":" + s);
            }
            System.out.println("*********************");

            /*添加到lists中*/
            lists.add(listdata);
            System.out.println(lists);

            // 打印聚类结果
            //System.out.println(KM.toString());

            // 评估（百分比）
            eval = new ClusterEvaluation();
            eval.setClusterer(KM);
            eval.evaluateClusterer(dataSet);
            System.out.println(eval.clusterResultsToString());
            String str = eval.clusterResultsToString();
            int begin = str.indexOf("Clustered Instances");
            String substring = str.substring(begin);
            String[] split = substring.split("\n");
            lists.add(split);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
//        return eval.clusterResultsToString();
    }


}

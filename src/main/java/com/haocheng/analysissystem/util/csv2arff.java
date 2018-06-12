package com.haocheng.analysissystem.util;

import weka.core.Instances;
import weka.core.converters.AbstractFileLoader;
import weka.core.converters.AbstractFileSaver;
import weka.core.converters.ConverterUtils;

import java.io.File;
import java.io.IOException;

public class csv2arff {
    /**
     * csv文件转raff文件
     */
    public static void dataConvert(String midpath, String despath) {
        File input = new File(midpath);
        File output = new File(despath);
        AbstractFileLoader loader = ConverterUtils.getLoaderForFile(input);
        AbstractFileSaver saver = ConverterUtils.getSaverForFile(output);
        try {
            loader.setSource(input);
            Instances data = loader.getDataSet();
//            System.out.println(data);
            saver.setInstances(data);
            saver.setFile(output);
//            saver.setDestination(output);
            saver.writeBatch();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

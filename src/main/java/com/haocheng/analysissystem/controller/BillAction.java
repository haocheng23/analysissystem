package com.haocheng.analysissystem.controller;

import com.haocheng.analysissystem.bean.*;
import com.haocheng.analysissystem.service.RechargeService;
import com.haocheng.analysissystem.service.TaoCanService;
import com.haocheng.analysissystem.util.kmeans;
import com.haocheng.analysissystem.vo.PieVo;
import com.haocheng.analysissystem.vo.ThreeD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BillAction {
    @Autowired
    private TaoCanService taoCanService;

    @Autowired
    private RechargeService rechargeService;

    /**
     * 畅销套餐
     *
     * @return
     */
    @RequestMapping("/toGetBestSaledTaocan")
    public String toGetBestSaledTaocan() {
        return "echarts/pie";
    }

    @PostMapping("/getPieData")
    @ResponseBody
    public List<TaoCanEntity> getPieData() {
        List<TaoCanEntity> list = taoCanService.getAll();
        return list;
    }

    /**
     * 订单充值费用情况
     *
     * @return
     */
    @RequestMapping("/toGetRechargeByFee")
    public String toGetRechargeByFee() {
        return "echarts/bar";
    }

    @RequestMapping("/GetBarData")
    @ResponseBody
    public List<RechargeFeeEntity> getBarData() {
        List<RechargeFeeEntity> list = rechargeService.getAll();
        return list;
    }


    /**
     * 订单充值省份分布
     *
     * @return
     */
    @RequestMapping("/toGetRechargeByProvince")
    public String toGetRechargeByProvince() {
        return "echarts/map";
    }

    @RequestMapping("/GetMapData")
    @ResponseBody
    public List<RechargeProvinceEntity> getMapData() {
        List<RechargeProvinceEntity> list = rechargeService.getAllByProv();
        return list;
    }

    /**
     * 订单充值时间分布
     *
     * @return
     */
    @RequestMapping("/toGetRechargeByTime")
    public String toGetRechargeByTime() {
        return "echarts/line";
    }

    @RequestMapping("/GetLineData")
    @ResponseBody
    public List<RechargeTimeEntity> getLineData() {
        List<RechargeTimeEntity> list = rechargeService.getAllByTime();
        return list;
    }

    /**
     * 省份充值总金额排行榜
     */
    @RequestMapping("/getRechargeProvTop")
    @ResponseBody
    public List<RechargeProvFeeEntity> getRechargeProvTop() {
        List<RechargeProvFeeEntity> list = rechargeService.getTopByProv();

        return list;
    }

    /**
     * 金额总量
     */
    @RequestMapping("/getMoneySum")
    @ResponseBody
    public Long getMoneySum() {
        Long moneySum = rechargeService.getMoneySum();
        return moneySum;
    }

    /**
     * 支付方式
     */
    @RequestMapping("/toGetPayWay")
    public String toGetPayWay() {
        return "echarts/circle";
    }

    @RequestMapping("/GetCircleData")
    @ResponseBody
    public List<PayWayEntity> GetCircleData() {
        List<PayWayEntity> list = rechargeService.getPayWay();
        return list;
    }

    /**
     * Kmeans聚类结果
     */
    @RequestMapping("/toGetScatterData")
    public String toGetScatterData() {
        return "echarts/scatter";
    }

    @RequestMapping("/getScatterData")
    @ResponseBody
    public ArrayList<ThreeD> GetScatterData() {
        List list = kmeans.exec();

        /*聚类中心点*/
        ArrayList<ThreeD> tdList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String s1 = list.get(i).toString();
            s1 = s1.substring(1, s1.length() - 1);
            String[] split = s1.split(",");
            double x = Double.parseDouble(split[0]);
            double y = Double.parseDouble(split[2]);
            double z = Double.parseDouble(split[1]);

            ThreeD threeD = new ThreeD();
            threeD.setX(x);
            threeD.setY(y);
            threeD.setZ(z);
            tdList.add(threeD);
        }

        /*其余样本点*/
        List list1 = (List) list.get(3);
        for (int i = 0; i < list1.size(); i++) {
            String s1 = list1.get(i).toString();
            String s2 = s1.split(":")[1];
            String[] split = s2.split(",");

            double x = Double.parseDouble(split[0]);
            double y = Double.parseDouble(split[2]);
            double z = Double.parseDouble(split[1]);

            ThreeD threeD = new ThreeD();
            threeD.setX(x);
            threeD.setY(y);
            threeD.setZ(z);
            tdList.add(threeD);
        }
        return tdList;
    }

    /**
     * Kmeans聚类结果
     */
    @RequestMapping("/toGetKmeansRes")
    public String toGetKmeansRes() {
        return "echarts/rose";
    }

    @RequestMapping("/getKmeansRes")
    @ResponseBody
    public List getKmeansRes() {
        List list = kmeans.exec();
        String[] str = (String[]) list.get(4);
        ArrayList<PieVo> list1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String type = str[i + 2].substring(0, 1);
            if (type.equals("0")){
                type = "语音多流量多";
            } else if (type.equals("1")){
                type = "语音多";
            } else {
                type = "语音多流量多短信多";
            }
            int count = Integer.parseInt(str[i + 2].substring(1, str[i + 2].indexOf("(")).trim());
            PieVo pieVo = new PieVo();
            pieVo.setType(type);
            pieVo.setCount(count);
            list1.add(pieVo);
        }
        return list1;
    }
}


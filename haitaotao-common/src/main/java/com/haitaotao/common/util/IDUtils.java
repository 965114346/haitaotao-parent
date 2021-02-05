package com.haitaotao.common.util;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 各种id生成策略
 * <p>Title: IDUtils</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年7月22日下午2:32:10
 * @version 1.0
 */
public class IDUtils {

	/**
	 * 图片名生成
	 */
	public static String genImageName() {
		//生成uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //文件路径
        return DateUtils.format(new Date(), "yyyyMMdd") + "/" + DateUtils.format(new Date(), "HHmmssS") + uuid.substring(0, 5);
	}
	
	/**
	 * 商品id生成
	 */
	public static long genItemId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}
}

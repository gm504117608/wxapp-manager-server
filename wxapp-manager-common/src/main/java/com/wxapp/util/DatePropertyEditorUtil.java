package com.wxapp.util;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;

import java.beans.PropertyEditorSupport;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DatePropertyEditorUtil extends PropertyEditorSupport{

	@Override
	public void setAsText(String arg0) throws IllegalArgumentException {
		LocalDate localDate = LocalDate.parse(arg0,DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
		this.setValue(localDate.toDate());
	}
	public static String accuracy(double num, double total, int scale){
		DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
		//可以设置精确几位小数
		df.setMaximumFractionDigits(scale);
		//模式 例如四舍五入
		df.setRoundingMode(RoundingMode.HALF_UP);
		double accuracy_num = num / total * 100;
		if(accuracy_num==0){
			return "0";
		}
		return df.format(accuracy_num);
	}
}

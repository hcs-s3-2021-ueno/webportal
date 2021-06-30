package jp.ac.hcs.s3a205.zipcode;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ZipCodeEntity {
	
	/** ステータス */
	private String status;
	
	/** メッセージ */
	private String message;
	
	/** 郵便番号の情報リスト */
	private List<ZipCodeData> results = new ArrayList<ZipCodeData>();

}

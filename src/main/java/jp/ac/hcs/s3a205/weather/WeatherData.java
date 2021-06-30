package jp.ac.hcs.s3a205.weather;

import lombok.Data;

/**
 * 1件分の天気情報
 * 各項目のデータ仕様について、APIの仕様を参照する
 * -https://weather.tsukumijima.net/
 */
@Data
public class WeatherData {
	
	/** 日付 */
	private String dataLabel;
	/** 予報 */
	private String telop;

}

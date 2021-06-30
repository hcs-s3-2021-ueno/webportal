package jp.ac.hcs.s3a205.weather;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/** 
 *　天気情報を操作する
 *　お天気APIを活用する
 *　- http://weather.tsukumijima.net/
 **/
@Transactional
@Service
public class WeatherService {
	
	@Autowired
	RestTemplate restTemplate;

	/** APIのリクエスト先URL */
	private static final String URL = "https://weather.tsukumijima.net/api/forecast?city={cityCode}";
	
	/**
	 * 気象情報取得業務ロジック
	 * @param cityCode 都市コード
	 * @return WeatherEntity
	 */
	public WeatherEntity getWeather(String cityCode) {
		
		// APIへアクセスして、結果を取得
		String json = restTemplate.getForObject(URL, String.class, cityCode);
		
		// エンティティクラスを作成
		WeatherEntity weatherEntity = new WeatherEntity();
		
		// jsonクラスへの変更失敗のため、例外処理
		try {
			//
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(json);
	
			//
			for(JsonNode forecast : node.get("forecasts")) {
				//
				WeatherData data = new WeatherData();
				//
				data.setDataLabel(forecast.get("dateLabel").asText());
				//
				data.setTelop(forecast.get("telop").asText());
				//
				weatherEntity.getForecasts().add(data);
			}
			
		} catch (IOException e) {
			// 例外発生時は、エラーメッセージの詳細を標準エラー出力
			e.printStackTrace();
		}
		
		return weatherEntity;
	}

}

package jp.ac.hcs.s3a205.zipcode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/** 
 *　郵便番号の情報を操作する
 *　zipcloud社の郵便番号検索APIを活用する
 *　- http://zipcloud.ibsnet.co.jp/doc/api
 **/
@Transactional
@Service
public class ZipCodeService {
	
	@Autowired
	RestTemplate restTemplate;

}

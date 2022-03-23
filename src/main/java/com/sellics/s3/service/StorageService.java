package com.sellics.s3.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.util.IOUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StorageService {

	@Value("${application.bucket.name}")
	private String bucketName;

	@Autowired
	private AmazonS3 s3Client;

	public byte[] downloadFile(final String fileName) {
		var s3Object = s3Client.getObject(bucketName, fileName);
		var inputStream = s3Object.getObjectContent();
		try {
			var content = IOUtils.toByteArray(inputStream);
			return content;
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

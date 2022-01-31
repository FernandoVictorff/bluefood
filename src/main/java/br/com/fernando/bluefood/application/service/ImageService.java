package br.com.fernando.bluefood.application.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.fernando.bluefood.util.IOUtils;

@Service
public class ImageService {
	
	@Value("${bluefood.files.logotipo}")
	private String logotiposDir;
	
	public void uploadLogotipo(MultipartFile multipartfile, String fileName) {
		try {
			IOUtils.copy(multipartfile.getInputStream(), fileName, logotiposDir);
		} catch (IOException e) {
			throw new ApplicationServiceException(e);
		}
	}
	
}

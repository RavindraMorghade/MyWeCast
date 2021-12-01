package com.wecast.helper;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.wecast.repo.ProfileRepository;
import com.wecast.request.Profile;

@Component
public class FileUploadHelper {

	@Autowired
	private ProfileRepository profileRepository;
	// public final String UPLOAD_DIR =
	// "E:\\AllJavaProjects\\RealTimeProject\\WeCast\\WeCast\\src\\main\\resources\\static\\image";
	public String UPLOAD_DIR = "E:\\AllJavaProjects\\WecastStaticData\\UserProfile";

	public boolean uploadFile(MultipartFile multipartFile, int userId) {
		boolean f = false;
		try {
			InputStream is = multipartFile.getInputStream();
			byte data[] = new byte[is.available()];

			is.read(data);
			String FinalPath = UPLOAD_DIR + "\\" + userId + "\\";
//FileOutputStream fos = new FileOutputStream(FinalPath + File.separator + multipartFile.getOriginalFilename());

			File directory = new File(FinalPath);
			directory.mkdirs();
			Path path1 = Paths.get(directory.getAbsolutePath() + System.getProperty("file.separator")
					+ multipartFile.getOriginalFilename());
			Files.write(path1, data);
			// fos.write(data);

			// fos.flush();
			// fos.close();

			Profile profile = new Profile();
			profile.setUserId(userId);
			profile.setProfileName(multipartFile.getOriginalFilename());
			profileRepository.save(profile);

			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}

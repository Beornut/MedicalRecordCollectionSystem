package cn.edu.njucm.Eye;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.sourceforge.tess4j.*;
import net.sourceforge.tess4j.util.ImageHelper;

public class OCR {
	public static String img2txt(String path){
		File imageFile = new File(path);
        BufferedImage grayImage = null;
		try {
			grayImage = ImageHelper.convertImageToBinary(ImageIO.read(imageFile));
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
        ITesseract instance = new Tesseract();
        instance.setDatapath(System.getProperty("user.dir"));
        instance.setLanguage("chi_sim");
        try {
            String result = instance.doOCR(grayImage);
            result = result.replaceAll("o", "。");
            result = result.replaceAll("[,'’‘]", "，");
            return result;
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
            return null;
        }
	}
}

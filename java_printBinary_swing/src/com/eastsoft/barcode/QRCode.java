package com.eastsoft.barcode;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 利用zxing�?��工具生成二维码QRCode
 */
public class QRCode {
	private static final int BLACK = 0xff000000;
	private static final int WHITE = 0xFFFFFFFF;

	public void encode(String str, String path, int width, int height) {
		try {
			Map hints = new HashMap();
			hints.put(EncodeHintType.MARGIN, 0);
			// hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
			hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
			BitMatrix byteMatrix = new MultiFormatWriter().encode(str,
					BarcodeFormat.QR_CODE, width, height, hints);
			
			/**
			 * tianboalei 2015-1-22
			 * 去掉生成二维码时周围的白圈
			 */
			//1
			int[] rec = byteMatrix.getEnclosingRectangle();
			int resWidth = rec[2] + 1;
			int resHeight = rec[3] + 1;
			BitMatrix resMatrix = new BitMatrix(resWidth, resHeight); 
			resMatrix.clear();
			for (int i = 0; i < resWidth; i++) {  
			    for (int j = 0; j < resHeight; j++) {  
			        if (byteMatrix.get(i + rec[0], j + rec[1])) { 
			             resMatrix.set(i, j); 
			        } 
			    }  
			}
			//2
			int widthT = resMatrix.getWidth();
			int heightT = resMatrix.getHeight();
			BufferedImage image = new BufferedImage(widthT, heightT,BufferedImage.TYPE_INT_ARGB);
			for (int x = 0; x < widthT; x++) {
			    for (int y = 0; y < heightT; y++) {
			        image.setRGB(x, y, resMatrix.get(x, y) == true ?
			        Color.BLACK.getRGB():Color.WHITE.getRGB());
			    }
			}
			/**
			 * 去掉二维码周围白圈结束
			 */
			
			File file = new File(path);
			writeToFile(resMatrix, "png", file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成QRCode二维�?br> 在编码时�?��将com.google.zxing.qrcode.encoder.Encoder.java中的<br>
	 * static final String DEFAULT_BYTE_MODE_ENCODING = "ISO8859-1";<br>
	 * 修改为UTF-8，否则中文编译后解析不了<br>
	 * 
	 * @param contents
	 *            二维码的内容
	 * @param file
	 *            二维码保存的路径，如：C://test_QR_CODE.png
	 * @param filePostfix
	 *            生成二维码图片的格式：png,jpeg,gif等格�?
	 * @param format
	 *            qrcode码的生成格式
	 * @param width
	 *            图片宽度
	 * @param height
	 *            图片高度
	 * @param hints
	 */
	public void encode(String contents, File file, String filePostfix,
			BarcodeFormat format, int width, int height,
			Map<EncodeHintType, ?> hints) {
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
					format, width, height);
			writeToFile(bitMatrix, filePostfix, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成二维码图�?br>
	 * 
	 * @param matrix
	 * @param format
	 *            图片格式
	 * @param file
	 *            生成二维码图片位�?
	 * @throws IOException
	 */
	public static void writeToFile(BitMatrix matrix, String format, File file)
			throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		ImageIO.write(image, format, file);
	}

	/**
	 * 生成二维码内�?br>
	 * 
	 * @param matrix
	 * @return
	 */
	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) == true ? BLACK : WHITE);
			}
		}
		return image;
	}

	/**
	 * 解析QRCode二维码
	 */
	@SuppressWarnings("unchecked")
	public void decode(File file) {
		try {
			BufferedImage image;
			try {
				image = ImageIO.read(file);
				if (image == null) {
					System.out.println("Could not decode image");
				}
				LuminanceSource source = new BufferedImageLuminanceSource(image);
				BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
						source));
				Result result;
				@SuppressWarnings("rawtypes")
				Hashtable hints = new Hashtable();
				// 解码设置编码方式为：utf-8
				hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
				result = new MultiFormatReader().decode(bitmap, hints);
				String resultStr = result.getText();
				System.out.println("解析后内容：" + resultStr);
			} catch (IOException ioe) {
				System.out.println(ioe.toString());
			} catch (ReaderException re) {
				System.out.println(re.toString());
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
}

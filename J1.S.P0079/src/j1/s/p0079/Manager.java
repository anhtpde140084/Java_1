/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0079;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author tranp
 */
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Manager {
	Scanner scan = new Scanner(System.in);

	Manager() {

	}

	void menu() {
		int option;
		System.out.printf("\n%-20s\n", "===================== MENU ====================");
		System.out.printf("%-20s\n", "1: Compression");
		System.out.printf("%-20s\n", "2: Extraction");
		System.out.printf("%-20s\n", "3: Exit");
		System.out.printf("\n%-20s\n", "===============================================");

		option = scan.nextInt();
		scan.nextLine();
		switch (option) {
		case 1:
			function_1();
			break;
		case 2:
			function_2();
			break;
		case 3:
			System.out.println("Exiting...");
		}
		if (option != 3)
			menu();
	}

	void function_1() {
		System.out.printf("%-20s\n", "Compression");
		System.out.println("Enter folder\\file: ");
		String oriPath = scan.nextLine();
		System.out.println("Enter destination folder: ");
		String path = scan.nextLine();
		System.out.println("Enter name: ");
		String name = scan.nextLine();
		try {
			byte[] buffer = new byte[1024];
			File f = new File(oriPath);
			if (f.isFile()) {

				OutputStream fos = new FileOutputStream(path + "/" + name);
				ZipOutputStream zos = new ZipOutputStream(fos);
				ZipEntry ze = new ZipEntry(oriPath); // file name
				zos.putNextEntry(ze);

				FileInputStream in = new FileInputStream(oriPath);
				int len;
				while ((len = in.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}
				in.close();

				zos.closeEntry();
				zos.close(); // remember close it
				System.out.println("Done");

			} else if (f.isDirectory()) {
				File fz = new File(path + "/" + name);
				fz.getParentFile().mkdirs();

				String abPath = f.getAbsolutePath();

				FileOutputStream fos = null;
				ZipOutputStream zos = null;

				try {
					List<File> allFiles = listChildFiles(f);
					fos = new FileOutputStream(fz);
					zos = new ZipOutputStream(fos);

					for (File file : allFiles) {
						String filePath = file.getAbsolutePath();
						System.out.println("Zipping " + file.getName());
						String entryName = filePath.substring(abPath.length() - 3);
						System.out.println("this: " + entryName);
						ZipEntry ze = new ZipEntry(entryName);
						zos.putNextEntry(ze);
						FileInputStream fis = new FileInputStream(filePath);

						int len;
						while ((len = fis.read(buffer)) > 0)
							zos.write(buffer, 0, len);
						fis.close();

					}
				} catch (Exception x) {

				} finally {
					zos.closeEntry();
					zos.close();
					fos.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void function_2() {
		System.out.printf("%-20s\n", "2: Extraction");
		System.out.printf("%-20s\n", "Compression");
		System.out.println("Enter file: ");
		String oriPath = scan.nextLine();
		System.out.println("Enter destination folder: ");
		String path = scan.nextLine();

		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdirs();
		}

		FileInputStream fis = null;
		ZipInputStream zis = null;
		CheckedInputStream checksum = null;
		try {
			byte[] BUFFER = new byte[1024];
			fis = new FileInputStream(oriPath);

			// Creating input stream that also maintains the checksum of the
			// data which later can be used to validate data integrity.
			checksum = new CheckedInputStream(fis, new Adler32());
			zis = new ZipInputStream(new BufferedInputStream(checksum));

			// Read each entry from the ZipInputStream until no more entry found
			// indicated by a null return value of the getNextEntry() method.
			ZipEntry entry;
			File file;
			OutputStream os;
			String entryName;
			String outFileName;
			while ((entry = zis.getNextEntry()) != null) {
				entryName = entry.getName();
				outFileName = path + File.separator + entryName;
				System.out.println("Unzip: " + outFileName);

				file = new File(outFileName);
				if (entry.isDirectory()) {
					// Tạo các thư mục.
					file.mkdirs();
				} else {
					// Tạo các thư mục nếu không tồn tại
					if (!file.getParentFile().exists()) {
						file.getParentFile().mkdirs();
					}
					// Tạo một Stream để ghi dữ liệu vào file.
					os = new FileOutputStream(outFileName);
					int len;
					while ((len = zis.read(BUFFER)) > 0) {
						os.write(BUFFER, 0, len);
					}
					os.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				zis.close();
			} catch (Exception e) {
			}
			try {
				zis.close();
			} catch (Exception e) {
			}
		}

		// Print out the checksum value
		if (checksum != null) {
			System.out.println("Checksum = " + checksum.getChecksum().getValue());
		}
	}

	List<File> listChildFiles(File dir) throws IOException {
		List<File> allFiles = new ArrayList<>();

		File[] childFiles = dir.listFiles();
		for (File file : childFiles) {
			if (file.isFile()) {
				allFiles.add(file);
			} else {
				List<File> files = listChildFiles(file);
				allFiles.addAll(files);
			}
		}
		return allFiles;
	}
}


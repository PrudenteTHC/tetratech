package com.tetratech.restservice.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import com.google.gson.Gson;
import com.tetratech.model.Populacao;

/**
 * Classe utilitária para auxiliar na manipulação de arquivos.
 * 
 * @author Thiago Prudente
 *
 */
public class FileUtil {

    private final Logger log = LoggerFactory.getLogger(FileUtil.class);
    
    private static final String ROOT_PATH = "C:\\";
	
	private static final String PATH_FILE = "report/";
	
	private static final String EXTENSION = ".txt";
	
	private static final String LOG_INFO_INITIAL = "writing file";
    
    private static FileUtil instance;
    
    private FileUtil() {}
    
    public static FileUtil getInstance() {
    	if (instance == null) {
    		instance = new FileUtil();
    	}
    	
    	return instance;
    }
	
	public void saveReportLine(String text, String fileName) {
		
    	log.info(LOG_INFO_INITIAL);
		
        String filePathAndName = PATH_FILE + fileName+ EXTENSION;
        	
    	File file = new File(filePathAndName);
		try {
			file = ResourceUtils.getFile(ROOT_PATH+filePathAndName);
		} catch (FileNotFoundException e1) {
			log.error(e1.getMessage());
		}
            
        try (
            FileWriter fw = new FileWriter(file, true);
        		BufferedWriter bw = new BufferedWriter(fw);
        	    PrintWriter out = new PrintWriter(bw)) {
        	out.println(text);
        	
        } catch (FileNotFoundException e) {
        	log.error(e.getMessage());
        } catch (IOException e) {
        	log.error(e.getMessage());
        }
    }
	
	public List<Populacao> readLinesFromFile(String fileName) throws IOException {
		
    	log.info(LOG_INFO_INITIAL);
		
        String filePathAndName = PATH_FILE + fileName+ EXTENSION;
        	
    	File file = new File(filePathAndName);
		try {
			file = ResourceUtils.getFile(ROOT_PATH+filePathAndName);
		} catch (FileNotFoundException e1) {
			log.error(e1.getMessage());
		}
            
        try (
            FileReader fw = new FileReader(file);
        		BufferedReader bw = new BufferedReader(fw)) {
        	
        	return bw.lines().map(line -> {
				return new Gson().fromJson(line, Populacao.class);
			}).collect(Collectors.toList());
        	
        }
        
    }

}

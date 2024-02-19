package com.gteam.gdsc.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.logging.Logger;

@RestController
public class PythonController {

    @GetMapping("/runOCR")
    public String runOCR() {
        try {
            // Python 스크립트 실행 명령어
            String[] command = {"python", "google_ocr_run.py", "--txt", "--words"};

            // ProcessBuilder를 사용하여 명령어 실행
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.directory(new File("C:\\Users\\User\\Desktop\\GDSC\\SolutionChallenge\\ocr")); // Python 스크립트가 있는 디렉토리 설정
            Process process = processBuilder.start();

            // 프로세스의 출력을 읽기 위한 BufferedReader 생성
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();

            // 프로세스 출력을 읽어들여 StringBuilder에 추가
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            System.out.println(line);

            // 프로세스가 완료될 때까지 대기
            int exitVal = process.waitFor();

            // 프로세스의 종료코드를 확인하여 처리
            if (exitVal == 0) {
                // 성공적으로 종료됨
                return "OCR 실행이 완료되었습니다.";
            } else {
                // 오류 발생 시
                return "OCR 실행 중 오류가 발생했습니다.";
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "OCR 실행 중 오류가 발생했습니다.";
        }
    }
}

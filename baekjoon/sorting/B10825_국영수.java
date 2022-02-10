package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Student {
    private String name;
    private int kor;
    private int eng;
    private int math;

    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setKor(int kor) {
        this.kor = kor;
    }
    public int getKor() {
        return kor;
    }
    public void setEng(int eng) {
        this.kor = kor;
    }
    public int getEng() {
        return eng;
    }
    public void setMath(int math) {
        this.kor = kor;
    }
    public int getMath() {
        return math;
    }
}

public class B10825_국영수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Student> list = new ArrayList<>();//Explicit type can be replaced with <>, better than <Student>

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String all = br.readLine();
            StringTokenizer st = new StringTokenizer(all);
            //입력시마다 Student 객체에 담아줌
            Student s = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(s);//ArrayList에 저장
        }

        //Comparator 정렬
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if(s1.getKor() == s2.getKor()) {// ● 국어 점수가 같다면
                    if(s1.getEng() == s2.getEng()) {// ★ 국어, 영어 점수가 같다면
                        if(s1.getMath() == s2.getMath()) {// ◆ 모든 점수가 같으면 then 이름이 사전 순으로 증가
                            return s1.getName().compareTo(s2.getName());
                        } else {// ★ then 수학 점수가 감소하는 순서로
                            return s2.getMath() - s1.getMath();
                        }
                    } else {// ● then 영어 점수가 증가하는 순서로
                        return s1.getEng() - s2.getEng();
                    }
                } else {//1. 국어 점수 감소하는 순서로
                    return s2.getKor() - s1.getKor();
                }
            }
        });

        //이름 하나씩 출력
        for(Student st : list) {
            System.out.println(st.getName());
        }
    }//main
}//class

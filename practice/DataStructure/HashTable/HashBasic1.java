package hashtable;
/*
    < HashTable Basic >
 */

//LinkedList 라이브러리 사용
import java.util.LinkedList;

class HashTable {
    class Node {//HashTable에 저장할 데이터를 Node에 담는다.
        String key;//검색할 key값
        String value;//검색 결과로 보여줄 value값

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
        //getter, setter
        public String value() {
            return value;
        }

        public void value(String value) {
            this.value = value;
        }
    }

    //LinkedList에는 방금 선언한 Node가 들어감
    LinkedList<Node>[] data;// data를 저장할 LinkedList를 배열로 선언

    //HashTable을 선언하는 순간, 어느 크기로 만들지 크기를 미리 정해서 만들어 놓는다.
    HashTable(int size) {
        this.data = new LinkedList[size];
    }

    int getHashCode(String key) {
        int hashcode = 0;//hashcode 0으로 초기화
        //입력받은 key 문자열을 돌면서 각 letter의 ASCII 값을 가져와서 hashcode에 더해준다.
        for (char c : key.toCharArray()) {
            hashcode += c;
        }
        return hashcode;
    }

    //hashcode를 받아서 배열방에 index로 변환해주는 함수 정의
    int convertToIndex(int hashcode) {
        return hashcode % data.length;//hashcode를 배열의 크기로 나눈 나머지가 배열방의 Index가 됨
    }

    //Index로 배열방을 찾은 이후에 배열방에 Node가 여러 개 존재하는 경우, key값으로 해당 Node를 찾는 함수 정의
    Node searchKey(LinkedList<Node> list, String key) {
        if (list == null) {//배열방이 null이면 null을 반환
            return null;
        }
        for (Node node : list) {//배열방의 LinkedList를 돌면서
            if (node.key.equals(key)) {//node의 key가 검색하는 key와 같은지 확인
                return node;//같으면 node 반환
            }
        }
        return null;
    }

    //data를 받아서 저장하는 함수 정의
    //저장할 key와 value를 인자로 받음
    void put(String key, String value) {
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);

        // hashcode 와 배열방 확인해보기
        System.out.println( key + ", hashcode(" + hashcode + "), index(" + index + ")");

        LinkedList<Node> list = data[index];
        if (list == null) {
            list = new LinkedList<Node>();//배열방이 null이면 LinkedList 생성
        }
        Node node = searchKey(list, key);//배열방에 기존의 해당 키로 데이터를 가지고 있는지 Node를 받아옴
        if (node == null) {
            list.addLast(new Node(key, value));//node가 null이면 data가 없으므로 받아온 정보를 가지고 Node 객체 생성하여 list에 추가
            data[index] = list;//해당 list를 배열방에 넣어줌
        } else {//node가 null이 아닌 경우, 해당 node의 값을 대체하는 것으로 중복 key 처리
            node.value(value);
        }
    }

    //key를 가지고 data 가져오는 get함수 정의
    String get(String key) {
        int hashcode = getHashCode(key);//key로 hashcode받아오기
        int index = convertToIndex(hashcode);//hashcode로 index 받아오기
        LinkedList<Node> list = data[index];
        Node node = searchKey(list, key);
        //node가 없으면 "Not found"문자열 출력, or 찾은 value 데이터 출력
        return node == null? "Not found" : node.value();
    }
}

public class HashBasic1 {
    public static void main(String[] args) {
        HashTable h = new HashTable(3);
        h.put("sung", "족발");
        h.put("jin", "먹고");
        h.put("hee", "싶");
        h.put("min", "어");
        h.put("sung", "쌀국수");//쌀국수로 update 

        //각각 key에 해당하는 value 값이 출력되는 것을 확인한다.
        System.out.println(h.get("sung"));
        System.out.println(h.get("jin"));
        System.out.println(h.get("hee"));
        System.out.println(h.get("min"));
        System.out.println(h.get("mn"));//Not found
        System.out.println(h.get("sung"));
    }
}

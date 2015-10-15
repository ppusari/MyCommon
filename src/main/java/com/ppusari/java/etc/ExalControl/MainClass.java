package com.ppusari.java.etc.ExalControl;

 
public class MainClass {
	
	public static void main(String[] args) {
		
		// 유니크한 값 생성
		UniqueKeyCreater uc = new UniqueKeyCreater();
		uc.getUniqueKeys(10);
		uc.print();		
		System.out.println("extraction end");
		
		// 엑셀이 데이터 저장하기
		ExcelExport ee = new ExcelExport();
		ee.CreateExcelFile("data/uniqueKey.xls");
		ee.WriteExcel(uc.getUniqueKeys());
		 
		// 엑셀에서 불러오기		
		ExcelImport ei = new ExcelImport();
		ei.ImportExeclFile("data/uniqueKey.xls");
		ei.print();
	}

}


/*
 * http://blog.naver.com/since890513/220172334976  <-- 위 예제 만든 소스
 * 참고사이트: http://hellogk.tistory.com/12  <-- 아래 주석내용
	

그럼 샘플 코드작성을 위해 임의의 시나리오를 작성해보겠습니다.

엑셀쓰기 시나리오
가상의 DB데이터를 담은 LIST객체의 데이터를 엑셀규격에 맞추어서 넣은다음 파일로 작성한다

그럼 위 시나리오에 맞추어 다음 코드를 보시겠습니다.

DB데이터를 담는 객체는 map 타입으로 진행을 하도록 하겠습니다.
같은 코드를 2003,2007 버전으로 나누어서 작성하도록 하겠습니다.

엑셀 2003(xls) 코드
//임의의 VO가 되주는 MAP 객체
Map<String,Object>map=null;
//가상 DB조회후 목록을 담을 LIST객체
ArrayList<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
ArrayList<String> columnList=new ArrayList<String>();
//DB조회후 데이터를 담았다는 가상의 데이터
for(int i=0;i<10;i++){
    map=new HashMap<String,Object>();
    map.put("seq", i+1);
    map.put("title", "제목이다"+i);
    map.put("content", "내용입니다"+i);
    list.add(map);
}
//MAP의 KEY값을 담기위함 
if(list !=null &&list.size() >0){
    //LIST의 첫번째 데이터의 KEY값만 알면 되므로 
    Map<String,Object> m=list.get(0);
    //MAP의 KEY값을 columnList객체에 ADD 
    for(String k : m.keySet()){
        columnList.add(k);
    }
}
//1차로 workbook을 생성 
HSSFWorkbook workbook=new HSSFWorkbook();
//2차는 sheet생성 
HSSFSheet sheet=workbook.createSheet("시트명");
//엑셀의 행 
HSSFRow row=null;
//엑셀의 셀 
HSSFCell cell=null;
//임의의 DB데이터 조회 
if(list !=null &&list.size() >0){
    int i=0;
    for(Map<String,Object> mapobject : list){
        // 시트에 하나의 행을 생성한다(i 값이 0이면 첫번째 줄에 해당) 
        row=sheet.createRow((short)i);
        i++;
        if(columnList !=null &&columnList.size() >0){
            for(int j=0;j<columnList.size();j++){
                //생성된 row에 컬럼을 생성한다 
                cell=row.createCell(j);
                //map에 담긴 데이터를 가져와 cell에 add한다 
                cell.setCellValue(String.valueOf(mapobject.get(columnList.get(j))));
            }
        }
    }
}
FileOutputStream fileoutputstream=new FileOutputStream("D:\\roqkffhwk.xls");
//파일을 쓴다
workbook.write(fileoutputstream);
//필수로 닫아주어야함 
fileoutputstream.close();
System.out.println("엑셀파일생성성공");

엑셀 2007(xlsx) 코드
//임의의 VO가 되주는 MAP 객체
Map<String,Object>map=null;
//가상 DB조회후 목록을 담을 LIST객체
ArrayList<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
ArrayList<String> columnList=new ArrayList<String>();
//DB조회후 데이터를 담았다는 가상의 데이터
for(int i=0;i<10;i++){
    map=new HashMap<String,Object>();
    map.put("seq", i+1);
    map.put("title", "제목이다"+i);
    map.put("content", "내용입니다"+i);
    list.add(map);
}
//MAP의 KEY값을 담기위함 
if(list !=null &&list.size() >0){
    //LIST의 첫번째 데이터의 KEY값만 알면 되므로 
    Map<String,Object>m=list.get(0);
    //MAP의 KEY값을 columnList객체에 ADD 
    for(String k : m.keySet()){
        columnList.add(k);
    }
}
//1차로 workbook을 생성 
XSSFWorkbook workbook=new XSSFWorkbook();
//2차는 sheet생성 
XSSFSheet sheet=workbook.createSheet("시트명");
//엑셀의 행 
XSSFRow row=null;
//엑셀의 셀 
XSSFCell cell=null;
//임의의 DB데이터 조회 
if(list !=null &&list.size() >0){
    int i=0;
    for(Map<String,Object>mapobject : list){
        // 시트에 하나의 행을 생성한다(i 값이 0이면 첫번째 줄에 해당) 
        row=sheet.createRow((short)i);
        i++;
        if(columnList !=null &&columnList.size() >0){
            for(int j=0;j<columnList.size();j++){
                //생성된 row에 컬럼을 생성한다 
                cell=row.createCell(j);
                //map에 담긴 데이터를 가져와 cell에 add한다 
                cell.setCellValue(String.valueOf(mapobject.get(columnList.get(j))));
            }
        }
    }
}
FileOutputStream fileoutputstream=new FileOutputStream("D:\\roqkffhwk2.xlsx");
//파일을 쓴다
workbook.write(fileoutputstream);
//필수로 닫아주어야함 
fileoutputstream.close();
System.out.println("엑셀파일생성성공");

xlsx 코드는 거의 동일하고 사용 API만 변경되었을 뿐입니다.

 
기존 "HSSFXXX" 시작된 API들을 "XSSFXXX" 로 변경되고 
추가로 파일명의 확장자를 "파일명.xlsx"으로 변경만 해주시면 됩니다.


Map타입으로 데이터를 담아서 엑셀에 쓰기작업을 진행하였으나 
dto,vo 객체를 이용하여 쓰는것 또한 가능합니다.*/
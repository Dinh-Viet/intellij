package exam;

import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Management {
    //Hàm tìm kiếm từ kháo trong thư mực
    public void getFiles(File fileSource, String word){
        int element = 0;
        // Liệt kê tất cả các thư mục và file rồi thêm chúng vào mảng
        File files[]=fileSource.listFiles();

        for (File len : files){
            // Nếu phần tử này là thư mục
            if(len.isDirectory()){
                //Tìm kiếm từ khóa trong thư mục bằng cách gọi đệ quy
                getFiles(len, word);
            }else {
                // Trường hợp này là file cụ thể là ".txt"
                if(len.getName().endsWith("txt")){
                    // Tìm kiếm từ trong file này
                    try{
                        int count = Work(len, word);
                        if(count > 0){
                            System.out.println("Found in: " + len.getAbsolutePath() + "//" + len.getName());
                            element++;
                        }else {
                            System.out.println("Not found in "+len.getAbsolutePath() +"//" + len.getName());
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        System.out.printf("Total of files that containing \"%s\": %d\n", word, element);
    }

    //Hàm đếm số lần xuất hiện của từ khóa trong file
    public int Work(File fileSource, String word){
        //Khai báo bộ đếm
        int count = 0;

        try{
            //Đọc nội dung file
            String content = readFile(fileSource);
            //Khai báo bộ tìm kiếm

            Pattern pattern = Pattern.compile(word);
            Matcher match = pattern.matcher(content);

            while (match.find()){
                count++;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return count;
    }

    // Hàm đọc nội dung file
    public String readFile(File fileSource) throws Exception{

        try{
            // Kết nối file với java tương tự như Scanner =new scanner(System.in);
            FileInputStream fileInputStream = new FileInputStream(fileSource);

            // Số lượng byte trong file
            int variables = fileInputStream.available();

            //Tạo mảng byte để chứa nội dung (Đang byte) từ file
            byte[] content = new byte[variables];

            // Tiến hành đọc file(Chuyển đổi byte thành dạng chữ cái)
            fileInputStream.read(content);

            //Đóng file sau khi đọc xong trasanh để tiêu hao RAM
            fileInputStream.close();

            //Tra về nội dung dạng chữ cái
            return (new String(content));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

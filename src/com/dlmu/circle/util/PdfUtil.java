package com.dlmu.circle.util;

import com.dlmu.circle.model.Student;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.*;
import java.io.*;
import java.util.List;

/**
 * Created by cf on 2017/5/29.
 */
public class PdfUtil {
    /**
     * 创建一份普通表格的PDF文件
     * @param fullFilePath
     * @return
     */
    public static boolean createNormalTable(String fullFilePath, List<Student> studentList, String[] tableHeadContent){

        Document pdfDocument = new Document();
        try {
            //构建一个PDF文档输出流程
            OutputStream pdfFileOutputStream = new FileOutputStream(new File(fullFilePath));
            PdfWriter.getInstance(pdfDocument,pdfFileOutputStream);
            //设置中文字体和字体样式
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font f8 = new Font(bfChinese, 8, Font.NORMAL);
            //打开PDF文件流
            pdfDocument.open();
            //创建一个N列的表格控件
            PdfPTable pdfTable = new PdfPTable(tableHeadContent.length);
            //设置表格占PDF文档100%宽度
            pdfTable.setWidthPercentage(100);
            //水平方向表格控件左对齐
            pdfTable.setHorizontalAlignment(PdfPTable.ALIGN_LEFT);
            //创建一个表格的表头单元格
            PdfPCell pdfTableHeaderCell = new PdfPCell();
            //设置表格的表头单元格颜色
            pdfTableHeaderCell.setBackgroundColor(new Color(213, 141, 69));
            pdfTableHeaderCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            for(String tableHeaderInfo : tableHeadContent){
                pdfTableHeaderCell.setPhrase(new Paragraph(tableHeaderInfo, f8));
                pdfTable.addCell(pdfTableHeaderCell);
            }
            //创建一个表格的正文内容单元格
            PdfPCell pdfTableContentCell = new PdfPCell();
            pdfTableContentCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            pdfTableContentCell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
            //表格内容行数的填充
            for(int i = 0;i < studentList.size();i++){
                Student student=studentList.get(i);
                String[] students=new String[]{student.getStuId()+"",student.getStuNo(),student.getStuName(),student.getSex(),student.getEmail(),student.getStuDesc()};
                for(String tableContentInfo : students){
                    pdfTableContentCell.setPhrase(new Paragraph(tableContentInfo, f8));
                    pdfTable.addCell(pdfTableContentCell);
                }
            }
            pdfDocument.add(pdfTable);
            return true;
        }catch(FileNotFoundException de) {
            de.printStackTrace();
            System.err.println("pdf file: " + de.getMessage());
            return false;
        }catch(DocumentException de) {
            de.printStackTrace();
            System.err.println("document: " + de.getMessage());
            return false;
        }catch(IOException de) {
            de.printStackTrace();
            System.err.println("pdf font: " + de.getMessage());
            return false;
        }finally{
            //关闭PDF文档流，OutputStream文件输出流也将在PDF文档流关闭方法内部关闭
            if(pdfDocument!=null){
                pdfDocument.close();
            }
        }
    }
}

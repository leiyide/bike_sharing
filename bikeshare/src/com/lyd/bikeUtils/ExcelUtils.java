package com.lyd.bikeUtils;

import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 * poi����Excel����
 * @author oracle
 */
public class ExcelUtils
{
	public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";
	public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";
//	public static String NO_DEFINE = "no_define";// δ������ֶ�
//	public static String DEFAULT_DATE_PATTERN = "yyyy��MM��dd��";// Ĭ�����ڸ�ʽ
//	public static int DEFAULT_COLOUMN_WIDTH = 17;
	public static Logger log = Logger.getLogger(ExcelUtils.class);

	/**
	 * ��ȡWorkbook
	 * @param fileName �ļ���
	 * @return Workbook
	 * @throws Exception �쳣
	 */
	public static Workbook getWorkbook(InputStream input,String fileName) throws Exception
	{
		Workbook wb = null;
		// ��ȡ�ļ���׺��
		String filePostFixName = getPostfix(fileName);
		// �����ļ���ʽ(2003����2007)����ʼ��
		if (filePostFixName.equals(OFFICE_EXCEL_2010_POSTFIX))
		{
			wb = new XSSFWorkbook(input);
		}
		else if (filePostFixName.equals(OFFICE_EXCEL_2003_POSTFIX))
		{
			wb = new HSSFWorkbook(input);
		}
		return wb;
	}

	@SuppressWarnings("deprecation")
	public static String getCellValue(Cell cell)
	{
		String cellValue = "";
		// ���ݸ�ʽ
		DataFormatter formatter = new DataFormatter();
		if (cell != null)
		{
			// ��Ԫ������
			switch (cell.getCellType())
			{
			case Cell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell))
				{
					// ȡֵ
					cellValue = formatter.formatCellValue(cell);
				}
				else
				{
					// ����
					double value = cell.getNumericCellValue();
					int intValue = (int) value;
					cellValue = value - intValue == 0 ? String.valueOf(intValue) : String.valueOf(value);
				}
				break;
			case Cell.CELL_TYPE_STRING:
				cellValue = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				cellValue = String.valueOf(cell.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_FORMULA:
				cellValue = String.valueOf(cell.getCellFormula());
				break;
			case Cell.CELL_TYPE_BLANK:
				cellValue = "";
				break;
			case Cell.CELL_TYPE_ERROR:
				cellValue = "";
				break;
			default:
				cellValue = cell.toString().trim();
				break;
			}
		}
		return cellValue.trim();
	}

	/**
	 * ��ȡ�ļ���׺��
	 * @param path �ļ�·��
	 * @return �ļ���׺��
	 */
	public static String getPostfix(String path)
	{
		if (path == null)
		{
			return "";
		}
		if (path.contains("."))
		{
			return path.substring(path.lastIndexOf(".") + 1, path.length());
		}
		return "";
	}
}

	/**
	 * ����Excel 2007 OOXML (.xlsx)��ʽ
	 * @param title ������
	 * @param headMap ����-��ͷ
	 * @param jsonArray ���ݼ�
	 * @param datePattern ���ڸ�ʽ����nullֵ��Ĭ�� ������
	 * @param colWidth �п� Ĭ�� ����17���ֽ�
	 * @param out �����
	 */
	/*@SuppressWarnings("deprecation")
	public static void exportExcelX(OutputStream out, List<Custom> prjList)
	{
		// ����һ��������
		XSSFWorkbook workbook = new XSSFWorkbook();
		// ��ͷ��ʽ
		CellStyle titleStyle = workbook.createCellStyle();
		titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		Font titleFont = workbook.createFont();
		titleFont.setFontHeightInPoints((short) 20);
		titleFont.setBoldweight((short) 700);
		titleStyle.setFont(titleFont);
		// ��ͷ��ʽ
		CellStyle headerStyle = workbook.createCellStyle();
		// headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		headerStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		Font headerFont = workbook.createFont();
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		headerStyle.setFont(headerFont);
		// ��Ԫ����ʽ
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		Font cellFont = workbook.createFont();
		cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		cellStyle.setFont(cellFont);
		// ����һ��(������)���
		XSSFSheet sheet = workbook.createSheet("�û�������Ϣ��");
		// ��
		XSSFRow titleRow = sheet.createRow(0);
		XSSFCell titleCell = titleRow.createCell(0);
		titleCell.setCellValue("�ͻ����");
		titleCell.setCellStyle(headerStyle);
		titleCell = titleRow.createCell(1);
		titleCell.setCellValue("�ͻ�����");
		titleCell.setCellStyle(headerStyle);
		titleCell = titleRow.createCell(2);
		titleCell.setCellValue("����ˮƽ");
		titleCell.setCellStyle(headerStyle);
		titleCell = titleRow.createCell(3);
		titleCell.setCellValue("�ֻ�");
		titleCell.setCellStyle(headerStyle);
		titleCell = titleRow.createCell(4);
		titleCell.setCellValue("qq");
		titleCell.setCellStyle(headerStyle);
		titleCell = titleRow.createCell(5);
		titleCell.setCellValue("����");
		titleCell.setCellStyle(headerStyle);
		titleCell = titleRow.createCell(6);
		titleCell.setCellValue("�ͻ�״̬");
		titleCell.setCellStyle(headerStyle);
		titleCell = titleRow.createCell(7);
		titleCell.setCellValue("��������");
		titleCell.setCellStyle(headerStyle);
		titleCell = titleRow.createCell(8);
		titleCell.setCellValue("����������");
		titleCell.setCellStyle(headerStyle);
		// �����������ݣ�����������
		if (prjList != null && prjList.size() > 0)
		{
			for (int i = 0; i < prjList.size(); i++)
			{
				// ������
				XSSFRow dataRow = sheet.createRow(i + 1);
				// �õ�һ�����ݣ�����ڱ��δ���������
				Custom prj = prjList.get(i);
				// ��
				XSSFCell newCell = dataRow.createCell(0);
				newCell.setCellValue(prj.getId());
				newCell.setCellStyle(cellStyle);

				newCell = dataRow.createCell(1);
				newCell.setCellValue(prj.getName());
				newCell.setCellStyle(cellStyle);
				
				newCell = dataRow.createCell(2);
				newCell.setCellValue(prj.getEducation());
				newCell.setCellStyle(cellStyle);
				
				newCell = dataRow.createCell(3);
				newCell.setCellValue(prj.getPhoneno());
				newCell.setCellStyle(cellStyle);
				
				newCell = dataRow.createCell(4);
				newCell.setCellValue(prj.getQq());
				newCell.setCellStyle(cellStyle);
				
				newCell = dataRow.createCell(5);
				newCell.setCellValue(prj.getEmail());
				newCell.setCellStyle(cellStyle);
				
				newCell = dataRow.createCell(6);
				newCell.setCellValue(prj.getCustomstatu());
				newCell.setCellStyle(cellStyle);
				
				newCell = dataRow.createCell(7);
				newCell.setCellValue(prj.getCreatedate());
				newCell.setCellStyle(cellStyle);
				
				newCell = dataRow.createCell(8);
				newCell.setCellValue(prj.getInvitename());
				newCell.setCellStyle(cellStyle);
			}
		}
		try
		{
			workbook.write(out);
			workbook.close();

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void downloadExcelFile(List<Custom> list, HttpServletResponse response)
	{
		try
		{
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			exportExcelX(os, list);
			byte[] content = os.toByteArray();
			InputStream is = new ByteArrayInputStream(content);
			// ����response���������Դ�����ҳ��
			response.reset();
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + new String((new Date().getTime() + ".xlsx").getBytes(), "iso-8859-1"));
			response.setContentLength(content.length);
			ServletOutputStream outputStream = response.getOutputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			BufferedOutputStream bos = new BufferedOutputStream(outputStream);
			byte[] buff = new byte[8192];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length)))
			{
				bos.write(buff, 0, bytesRead);
			}
			bis.close();
			bos.close();
			outputStream.flush();
			outputStream.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception
	{
		OutputStream outXlsx = new FileOutputStream("E:\\aa\\bb\\custom.xlsx");
		System.out.println("���ڵ���xlsx....");
		List<Custom> prjList = new ArrayList<Custom>();
		Custom prj = new Custom();
		prj.setId(2017);
		prj.setName("����");;
		prj.setEducation("����");
		prj.setPhoneno("123456");
		prj.setQq(1235456);
		prj.setEmail("123456.@qq.com");
		prj.setCustomstatu("1");
		prj.setCreatedate(new Date());
		prj.setInvitename("��Ȼ");
		prjList.add(prj);
		exportExcelX(outXlsx, prjList);
		outXlsx.close();

//		log.info("�����ļ���ʼ...");
//		System.out.println("�����ļ���ʼ...");
//		String fileName = "D:\\temp\\1108.xls";
//		Workbook wb = getWorkbook(fileName);
//		// �õ���һ��sheet
//		Sheet sheet = wb.getSheetAt(0);
//		// ѭ���У���0��ʼ
//		for (int i = 1; i < 8; i++)
//		{
//			UserInfo user = new UserInfo();
//			log.info("�ļ�������" + (i + 1));
//			// ��
//			Row row = sheet.getRow(i);
//			user.setUserId(getCellValue(row.getCell(0)));
//			user.setUserName(getCellValue(row.getCell(1)));
//
//			// ѭ���У���0��ʼ
//			for (int j = 0; j < 8; j++)
//			{
//				if (row != null)
//				{
//					String cellValue = getCellValue(row.getCell(j));
//					// System.out.println(cellValue);
//					System.out.println("��" + (i + 1) + "�е�" + (j + 1) + "�е�ֵ��" + cellValue);
//				}
//			}
//		}
//		log.info("�����ļ�����.");
//		wb.close();
}

}
*/
package watermarkChecker;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfWatermarkChecker {
    
    public static void main(String[] args) throws Exception {
//        String filePath = "C:\\Users\\acer\\Desktop\\my_details\\sscApplication\\surissc.pdf";
    	String filePath = "C:\\Users\\acer\\git\\PracticeMaven\\precticeMaven\\samplePdfs\\sample(Draft).pdf";
        PDDocument document = PDDocument.load(new File(filePath));
        
        
        PDFReader pd = new PDFReader();
        
        pd.PDFBoxExtractImages(document);
        
        System.out.println("done");
        
        File a = new File("C:\\Users\\acer\\git\\PracticeMaven\\precticeMaven\\target\\20190326013505_IMG_6796-01.jpg");
        File b = new File("C:\\\\Users\\\\acer\\\\git\\\\PracticeMaven\\\\precticeMaven\\\\target\\\\20190326013505_IMG_6796-03.jpg");
        pd.imageCompare(a, b);
        
        
        
        
        
        
        
        
        
        boolean hasWatermark = false;
        
        // check for text watermark
        PDFTextStripper stripper = new PDFTextStripper();
        stripper.setStartPage(1);
        stripper.setEndPage(document.getNumberOfPages());
        String text = stripper.getText(document);
        System.out.println(text);
        if (text.contains("Draft")) {
            hasWatermark = true;
        }
        
        PDResources resources = document.getPage(0).getResources();
        if (resources != null) {
            for (COSName xObjectName : resources.getXObjectNames()) {
                PDXObject obj = resources.getXObject(xObjectName);
                if (obj instanceof PDImageXObject) {
                    // check for image watermark
                	System.out.println(obj);
                    PDImageXObject image = (PDImageXObject) obj;
                    System.out.println(image.getMetadata());
//                	if (image.getOpacity() < 1.0f && image.getWidth() > 100 && image.getHeight() > 100) {
//                        hasWatermark = true;
//                    }
                }
            }
        }
        
 /*       
        // check for image watermark
        for (int i = 0; i < document.getNumberOfPages(); i++) {
            for (PDXObject obj : document.getPage(i).getResources().getXObjectNames().values()) {
                if (obj instanceof PDImageXObject) {
                    PDImageXObject image = (PDImageXObject) obj;
                    if (image.getOpacity() < 1.0f && image.getWidth() > 100 && image.getHeight() > 100) {
                        hasWatermark = true;
                    }
                }
            }
        }
        */
        if (hasWatermark) {
            System.out.println("PDF file contains a watermark");
        } else {
            System.out.println("PDF file does not contain a watermark");
        }
       
        document.close();
    }
    
}


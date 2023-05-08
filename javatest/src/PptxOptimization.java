//import com.openai.api.ApiException;
//import com.openai.api.models.CompletionRequest;
//import com.openai.api.models.CompletionResponse;
//import com.openai.api.models.Engine;
//import com.openai.api.models.Model;
//import org.apache.poi.xslf.usermodel.XMLSlideShow;
//import org.apache.poi.xslf.usermodel.XSLFShape;
//import org.apache.poi.xslf.usermodel.XSLFSlide;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.List;
//
//public class PptxOptimization {
//
//    public static void main(String[] args) {
//
//        // OpenAI API密钥
//        String apiKey = "YOUR_API_KEY_HERE";
//
//        // PowerPoint演示文稿文件路径
//        String pptFile = "path/to/your/pptx/file.pptx";
//
//        try {
//            // 获取演示文稿文本内容
//            FileInputStream fis = new FileInputStream(pptFile);
//            XMLSlideShow ppt = new XMLSlideShow(fis);
//            StringBuilder text = new StringBuilder();
//            List<XSLFSlide> slides = ppt.getSlides();
//            for (XSLFSlide slide : slides) {
//                List<XSLFShape> shapes = slide.getShapes();
//                for (XSLFShape shape : shapes) {
//                    if (shape.hasText()) {
//                        text.append(shape.getText());
//                    }
//                }
//            }
//
//            // 使用OpenAI GPT-3生成摘要
//            CompletionRequest request = new CompletionRequest();
//            request.setEngine(Engine.DAVINCI);
//            request.setModel(new Model().setId("text-davinci-002"));
//            request.setPrompt(text.toString());
//            request.setMaxTokens(200);
//            request.setN(1);
//            CompletionResponse response = openai.api.Completions.create(apiKey, request);
//
//            // 将生成的摘要替换演示文稿中原有文本
//            String summary = response.getChoices().get(0).getText();
//            for (XSLFSlide slide : slides) {
//                List<XSLFShape> shapes = slide.getShapes();
//                for (XSLFShape shape : shapes) {
//                    if (shape.hasText()) {
//                        shape.setText(summary);
//                    }
//                }
//            }
//
//            // 保存优化后的演示文稿
//            FileOutputStream fos = new FileOutputStream("path/to/your/new/pptx/file.pptx");
//            ppt.write(fos);
//            fos.close();
//            ppt.close();
//        } catch (IOException | ApiException e) {
//            e.printStackTrace();
//        }
//    }
//}

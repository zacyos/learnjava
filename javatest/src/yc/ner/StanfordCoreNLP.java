package yc.ner;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.util.CoreMap;

import java.util.List;


/**
 * https://stanfordnlp.github.io/CoreNLP/api.html#quickstart-with-convenience-wrappers
 */
public class StanfordCoreNLP {

    private static AbstractSequenceClassifier<CoreLabel> ner;

    static {
        try {
            // 加载英文NER模型，对于其他语言，需要加载对应的模型
            String nerModelPath = "path/to/your/ner/model.ser.gz"; // 替换为你的NER模型路径
            ner = CRFClassifier.getClassifier(nerModelPath);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    static private Boolean judgeIsName(String name) {
        // 使用NER模型对文本进行标注
        List<CoreLabel> sentences = ner.classify(name).get(0);


        // 遍历每个句子中的每个单词/标记
        for (CoreMap sentence : sentences) {
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                // 检查当前标记的NER标签是否为"PERSON"
                if (token.get(CoreAnnotations.NamedEntityTagAnnotation.class).equals("PERSON")) {
                    return true; // 如果找到人名，则返回true
                }
            }
        }
        return false; // 如果没有找到人名，则返回false
    }


    public static void main(String[] args) {
        // 测试代码
        String testLine = "Barack Obama is the former president of the United States.";
        System.out.println("Contains person name: " + judgeIsName(testLine)); // 应该输出true
    }
}

package lab3.dictionaries;

import lab3.models.text.GenderOrMultiple;
import lab3.models.text.Label;

public class LabelDicrionary {
    public static final Label Mountains = new Label("горы", "гор", "горам", "горы", "горами", "горах",
            GenderOrMultiple.Multiple);
    public static final Label Clouds = new Label("облака", "облака", "облакам", "облака", "облаками", "облаках",
            GenderOrMultiple.Multiple);
    public static final Label Slopes = new Label("склоны", "склон", "склонам", "склоны", "склонами", "склонах",
            GenderOrMultiple.Multiple);
    public static final Label Tops = new Label("вершины", "вершину", "вершинам", "вершины", "вершинами", "вершинах",
            GenderOrMultiple.Multiple);
    public static final Label Hand = new Label("рука", "руки", "руке", "руку", "рукой", "руке",
            GenderOrMultiple.Female);
    public static final Label Outlines = new Label("очертания", "очертаний", "очертаниям", "очертания",
            "очертаниями", "очертаниях", GenderOrMultiple.Multiple);
    public static final Label Sea = new Label("море", "моря", "морю", "море", "морем", "море",
            GenderOrMultiple.Neuter);
    public static final Label Traveler = new Label("путешественник", "путешественника", "путешественнику",
            "путешественника", "путешественником", "путешественнике", GenderOrMultiple.Male);
    public static final Label Sky = new Label("небо", "неба", "небу", "небо", "небом", "небе",
            GenderOrMultiple.Neuter);
    public static final Label Thoughts = new Label("мысли", "мысли", "мыслям", "мысли", "мыслями", "мыслях",
            GenderOrMultiple.Multiple);
    public static final Label Fastness = new Label("быстрота", "быстроты", "быстроте", "быстроту", "быстротой",
            "быстроте", GenderOrMultiple.Female);
    public static final Label Lightning = new Label("молния", "молнии", "молнии", "молнию", "молнией",
            "молнии", GenderOrMultiple.Female);
    public static final Label Head = new Label("голова", "головы", "голове", "голову", "головой", "голове",
            GenderOrMultiple.Female);

    // Actor's names
    public static final Label NameDunno = new Label("Незнайка", "Незнайки", "Незнайке", "Незнайку", "Незнайкой",
            "Незнайке", GenderOrMultiple.Male);
    public static final Label NameDonut = new Label("Пончик", "Пончика", "Пончику", "Пончика", "Пончиком",
            "Пончике", GenderOrMultiple.Male);

}

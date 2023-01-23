package org.itmo.prog.lab3.dictionaries;

import org.itmo.prog.lab3.models.text.GenderOrPlural;
import org.itmo.prog.lab3.models.text.Label;

public class LabelDicrionary {
    public static final Label Mountains = new Label("горы", "гор", "горам", "горы", "горами", "горах",
            GenderOrPlural.Plural);
    public static final Label Clouds = new Label("облака", "облака", "облакам", "облака", "облаками", "облаках",
            GenderOrPlural.Plural);
    public static final Label Slopes = new Label("склоны", "склон", "склонам", "склоны", "склонами", "склонах",
            GenderOrPlural.Plural);
    public static final Label Tops = new Label("вершины", "вершину", "вершинам", "вершины", "вершинами", "вершинах",
            GenderOrPlural.Plural);
    public static final Label Hand = new Label("рука", "руки", "руке", "руку", "рукой", "руке",
            GenderOrPlural.Female);
    public static final Label Outlines = new Label("очертания", "очертаний", "очертаниям", "очертания",
            "очертаниями", "очертаниях", GenderOrPlural.Plural);
    public static final Label Sea = new Label("море", "моря", "морю", "море", "морем", "море",
            GenderOrPlural.Neuter);
    public static final Label Traveler = new Label("путешественник", "путешественника", "путешественнику",
            "путешественника", "путешественником", "путешественнике", GenderOrPlural.Male);
    public static final Label Sky = new Label("небо", "неба", "небу", "небо", "небом", "небе",
            GenderOrPlural.Neuter);
    public static final Label Thoughts = new Label("мысли", "мысли", "мыслям", "мысли", "мыслями", "мыслях",
            GenderOrPlural.Plural);
    public static final Label Fastness = new Label("быстрота", "быстроты", "быстроте", "быстроту", "быстротой",
            "быстроте", GenderOrPlural.Female);
    public static final Label Lightning = new Label("молния", "молнии", "молнии", "молнию", "молнией",
            "молнии", GenderOrPlural.Female);
    public static final Label Head = new Label("голова", "головы", "голове", "голову", "головой", "голове",
            GenderOrPlural.Female);

    // Actor's names
    public static final Label NameDunno = new Label("Незнайка", "Незнайки", "Незнайке", "Незнайку", "Незнайкой",
            "Незнайке", GenderOrPlural.Male);
    public static final Label NameDonut = new Label("Пончик", "Пончика", "Пончику", "Пончика", "Пончиком",
            "Пончике", GenderOrPlural.Male);

}

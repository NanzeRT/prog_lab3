package lab3.dictionaries;

import javax.annotation.Nonnull;

import lab3.models.text.Label;

public class LabelDicrionary {
    public static final @Nonnull Label Mountains = new Label("горы", "гор", "горам", "горы", "горами", "горах");
    public static final @Nonnull Label Clouds = new Label("облака", "облака", "облакам", "облака", "облаками", "облаках");
    public static final @Nonnull Label Slopes = new Label("склоны", "склон", "склонам", "склоны", "склонами", "склонах");
    public static final @Nonnull Label Tops = new Label("вершины", "вершину", "вершинам", "вершины", "вершинами", "вершинах");
    public static final @Nonnull Label Hand = new Label("рука", "руки", "руке", "руку", "рукой", "руке");
    public static final @Nonnull Label Outline = new Label("очертания", "очертаний", "очертаниям", "очертания", "очертаниями",
            "очертаниях");
    public static final @Nonnull Label Sea = new Label("море", "моря", "морю", "море", "морем", "море");
    public static final @Nonnull Label Traveler = new Label("путешественник", "путешественника", "путешественнику",
            "путешественника", "путешественником", "путешественнике");
    public static final @Nonnull Label Sky = new Label("небо", "неба", "небу", "небо", "небом", "небе");

    // Actor's names
    public static final @Nonnull Label NameDunno = new Label("Незнайка", "Незнайки", "Незнайке", "Незнайку", "Незнайкой",
            "Незнайке");
    public static final @Nonnull Label NameDonut = new Label("Пончик", "Пончика", "Пончику", "Пончика", "Пончиком", "Пончике");

}

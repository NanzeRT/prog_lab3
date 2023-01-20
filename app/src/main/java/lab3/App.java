package lab3;

import lab3.dictionaries.AdverbDictionary;
import lab3.dictionaries.LabelDicrionary;
import lab3.dictionaries.ModifierDictionary;
import lab3.models.actors.Group;
import lab3.models.actors.Sense;
import lab3.models.actors.Shorty;
import lab3.models.environment.MountainSlopes;
import lab3.models.environment.MountainTops;
import lab3.models.environment.Mountains;
import lab3.models.environment.Sky;
import lab3.models.environment.Valley;
import lab3.models.scene.Scene;
import lab3.models.text.CompoundMidifier;
import lab3.models.text.GenderOrMultiple;
import lab3.models.text.Name;

public class App {
    public static void main(String[] args) {
        var scene = new Scene();

        scene.setMainActor(new Shorty(new Name(LabelDicrionary.NameDunno), GenderOrMultiple.Male, new Sense()));

        scene.addActor(new Shorty(new Name(LabelDicrionary.NameDonut), GenderOrMultiple.Male, new Sense()));

        try {
            scene.addGroup(new Group(
                    scene.getActor(LabelDicrionary.NameDunno),
                    scene.getActor(LabelDicrionary.NameDonut)));
        } catch (Scene.ActorNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        // По правую руку, невдалеке от наших путешественников, были такие же
        // огненно-красные горы. Они как бы вздымались со дна окаменевшего моря и
        // тянулись своими заостренными верхушками к небу. Обернувшись назад. Незнайка и
        // Пончик увидели вдали горы, имевшие более смутные очертания. Казалось, они
        // были словно из ваты и по своему виду напоминали лежавшие на Земле облака. На
        // их вершинах и склонах, будто фантастические стеклянные замки, торчали
        // гигантские кристаллы, напоминавшие по форме кристаллы горного хрусталя.
        // Солнечный свет преломлялся в гранях этих кристаллов, благодаря чему они
        // сверкали всеми цветами радуги.

        scene.addEnvinronment(new Mountains(
                new Name(LabelDicrionary.Mountains).addModifier(
                        new CompoundMidifier(AdverbDictionary.Flamely, ModifierDictionary.RedMultiple)),
                new MountainTops(
                        new Name(LabelDicrionary.Tops).addModifier(ModifierDictionary.SharpenedMultiple)),
                new MountainSlopes(new Name(LabelDicrionary.Slopes))));

        scene.addEnvinronment(new Mountains(
                new Name(LabelDicrionary.Mountains).addModifier(
                        ModifierDictionary.VauglyOutlinedMultiple),
                new MountainTops(
                        new Name(LabelDicrionary.Tops)),
                new MountainSlopes(new Name(LabelDicrionary.Slopes))));

        scene.addEnvinronment(new Valley(
                new Name(LabelDicrionary.Sea).addModifier(
                        ModifierDictionary.StonedMiddle)));
        
        scene.addEnvinronment(new Sky(null));
    }
}

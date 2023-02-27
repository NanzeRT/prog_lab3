package org.itmo.prog.lab3;

import org.itmo.prog.lab3.dictionaries.AdverbDictionary;
import org.itmo.prog.lab3.dictionaries.LabelDicrionary;
import org.itmo.prog.lab3.dictionaries.ModifierDictionary;
import org.itmo.prog.lab3.dictionaries.VerbDictionary;
import org.itmo.prog.lab3.models.actions.ActionWithTargetFromVerb;
import org.itmo.prog.lab3.models.actions.ComparedAlikeAction;
import org.itmo.prog.lab3.models.actions.DidntOpenedItselfAction;
import org.itmo.prog.lab3.models.actions.DidntSuccumbedAction;
import org.itmo.prog.lab3.models.actions.ExpectedAction;
import org.itmo.prog.lab3.models.actions.HuggedAction;
import org.itmo.prog.lab3.models.actions.OpenedItselfAction;
import org.itmo.prog.lab3.models.actions.PiledUpAction;
import org.itmo.prog.lab3.models.actions.PressedAction;
import org.itmo.prog.lab3.models.actions.SoaredUpAction;
import org.itmo.prog.lab3.models.actions.SweptAction;
import org.itmo.prog.lab3.models.actions.WantingToCheerUpAction;
import org.itmo.prog.lab3.models.actions.WasAvailableAction;
import org.itmo.prog.lab3.models.actions.formatters.DirectFormatter;
import org.itmo.prog.lab3.models.actions.formatters.NoNameFormatter;
import org.itmo.prog.lab3.models.actions.formatters.PronounDirectFormatter;
import org.itmo.prog.lab3.models.actions.formatters.ReverseFormatter;
import org.itmo.prog.lab3.models.actions.formatters.ReverseFormatterWithInsert;
import org.itmo.prog.lab3.models.actions.results.ActionResultBinary;
import org.itmo.prog.lab3.models.actors.Group;
import org.itmo.prog.lab3.models.actors.Sense;
import org.itmo.prog.lab3.models.actors.Shorty;
import org.itmo.prog.lab3.models.common.Appearance;
import org.itmo.prog.lab3.models.common.Property;
import org.itmo.prog.lab3.models.environment.Mountains;
import org.itmo.prog.lab3.models.environment.Sky;
import org.itmo.prog.lab3.models.environment.Valley;
import org.itmo.prog.lab3.models.scene.Scene;
import org.itmo.prog.lab3.models.scene.Scene.SceneElementNotFoundException;
import org.itmo.prog.lab3.models.text.CompoundMidifier;
import org.itmo.prog.lab3.models.text.Frase;
import org.itmo.prog.lab3.models.text.GenderOrPlural;
import org.itmo.prog.lab3.models.text.Name;
import org.itmo.prog.lab3.models.text.Text;
import org.itmo.prog.lab3.utils.fluid_text.FluidText;

public class App {
    public static void main(String[] args) {
        Text story;
        try {
            story = getStory();
            System.out.println(story.getText());
        } catch (SceneElementNotFoundException e) {
            System.out.println("There is something wrong with the story");
            System.out.println(e.getMessage());
            return;
        }
    }

    private static Text getStory() throws SceneElementNotFoundException {
        var scene = new Scene();

        scene.addActor(new Shorty(new Name(LabelDicrionary.NameDunno), GenderOrPlural.Male, new Sense()));

        scene.addActor(new Shorty(new Name(LabelDicrionary.NameDonut), GenderOrPlural.Male, new Sense()));

        scene.addActor(new Group(
                scene.getActor(LabelDicrionary.NameDunno),
                scene.getActor(LabelDicrionary.NameDonut)));

        scene.setMainActor(LabelDicrionary.NameDunno.getName());

        scene.addEnvinronment(new Mountains(
                new Name(LabelDicrionary.Mountains).addModifier(
                        new CompoundMidifier(AdverbDictionary.Brightly, ModifierDictionary.RedMultiple)),
                new Mountains.Tops(
                        new Name(LabelDicrionary.Tops)),
                new Mountains.Slopes(new Name(LabelDicrionary.Slopes))));

        scene.addEnvinronment(new Mountains(
                new Name(LabelDicrionary.Mountains).addModifier(
                        new CompoundMidifier(AdverbDictionary.Flamely, ModifierDictionary.RedMultiple)),
                new Mountains.Tops(
                        new Name(LabelDicrionary.Tops).addModifier(ModifierDictionary.SharpenedMultiple)),
                new Mountains.Slopes(new Name(LabelDicrionary.Slopes))));

        scene.addEnvinronment(new Mountains(
                new Name(LabelDicrionary.Mountains).addModifier(
                        ModifierDictionary.VauglyOutlinedMultiple),
                new Mountains.Tops(
                        new Name(LabelDicrionary.Tops)),
                new Mountains.Slopes(new Name(LabelDicrionary.Slopes))));

        scene.addEnvinronment(new Valley(
                new Name(LabelDicrionary.Sea).addModifier(
                        ModifierDictionary.StonedMiddle)));

        scene.addEnvinronment(new Sky(new Name(LabelDicrionary.Sky)));

        var story = new Text();

        // Эти мысли с быстротой молнии пронеслись в голове у Незнайки.
        story.addFrase(new Frase(
                FluidText.these(LabelDicrionary.Thoughts)
                        .with(FluidText.fluid(LabelDicrionary.Fastness).of(LabelDicrionary.Lightning))
                        .doAction(new SweptAction())
                        .in(FluidText.fluid(LabelDicrionary.Head)
                                .inU(scene.getMainActor()))
                        .getTextByFormatter(new DirectFormatter())));

        // Но он не поддался страху.
        story.addFrase(new Frase().but(
                FluidText.fluid(scene.getMainActor())
                        .doAction(new DidntSuccumbedAction(LabelDicrionary.Fear))
                        .getTextByFormatter(new PronounDirectFormatter())));

        // Как бы желая подбодрить Пончика, он обнял его одной рукой за плечо, а другой
        // рукой нажал кнопку у двери.
        story.addFrase(new Frase().asIf(
                FluidText.fluid(scene.getMainActor())
                        .doAction(new WantingToCheerUpAction(scene.getActor(LabelDicrionary.NameDonut)))
                        .getTextByFormatter(new NoNameFormatter()))
                .comma(FluidText.fluid(scene.getMainActor())
                        .doAction(new HuggedAction(FluidText.pronoun(scene.getActor(LabelDicrionary.NameDonut))))
                        .using(new Name(LabelDicrionary.Hand).addModifier(ModifierDictionary.OneFemale))
                        .forr(LabelDicrionary.Shoulder)
                        .getTextByFormatter(new PronounDirectFormatter()))
                .a(FluidText.using(new Name(LabelDicrionary.Hand).addModifier(ModifierDictionary.OtherFemale),
                        FluidText.fluid(scene.getMainActor())
                                .doAction(new PressedAction(FluidText.fluid(LabelDicrionary.Button)
                                        .inU(FluidText.fluid(LabelDicrionary.Door)))))
                        .getTextByFormatter(new NoNameFormatter())));

        // Но дверь не открылась, как ожидал Незнайка.
        story.addFrase(new Frase().but(
                FluidText.fluid(LabelDicrionary.Door)
                        .doAction(new DidntOpenedItselfAction())
                        .getTextByFormatter(new DirectFormatter()))
                .as(FluidText.fluid(scene.getMainActor())
                        .doAction(new ExpectedAction())
                        .getTextByFormatter(new ReverseFormatter())));

        var littleHole = FluidText.fluid(new Name(LabelDicrionary.Hole).addModifier(ModifierDictionary.LittleNeuter));

        // Открылось лишь крошечное отверстие, имевшееся в двери.
        story.addFrase(new Frase(
                littleHole.doAction(new OpenedItselfAction())
                        .getTextByFormatter(new ReverseFormatterWithInsert("лишь")))
                .comma(littleHole.doAction(new WasAvailableAction())
                        .in(FluidText.fluid(LabelDicrionary.Door))
                        .getTextByFormatter(new NoNameFormatter())));

        // Пространство внутри шлюза соединилось с наружным безвоздушным пространством,
        // и воздух, находившийся в шлюзовой камере, со свистом начал вырываться на
        // свободу.
        story.addFrase(new Frase(
                FluidText.fluid(LabelDicrionary.Space)
                        .inside(LabelDicrionary.Gateway)
                        .doAction(new ActionWithTargetFromVerb(VerbDictionary.ConnectedWith,
                                FluidText.fluid(new Name(LabelDicrionary.Space)
                                        .addModifier(ModifierDictionary.OuterNeuter)
                                        .addModifier(ModifierDictionary.AirlessNeuter))))
                        .getTextByFormatter(new DirectFormatter()))
                // region
                .and("воздух, находившийся в шлюзовой камере, со свистом начал вырываться на свободу"));

        // Незнайка и Пончик почувствовали, что комбинезоны, которые прежде плотно
        // прилегали к телу, вдруг начали становиться просторнее, словно раздувались.
        story.addFrase(new Frase(
                "Незнайка и Пончик почувствовали, что комбинезоны, которые прежде плотно прилегали к телу, вдруг начали становиться просторнее, словно раздувались"));

        // Это объяснялось тем, что давление наружного воздуха исчезло и стенки
        // скафандров стали испытывать лишь давление воздуха изнутри.
        story.addFrase(new Frase(
                "это объяснялось тем, что давление наружного воздуха исчезло и стенки скафандров стали испытывать лишь давление воздуха изнутри"));

        // Не поняв, что произошло, Пончик вообразил, что скафандр на нем лопнул, и это
        // так напугало его, что он зашатался и начал валиться на бок.
        story.addFrase(new Frase(
                "не поняв, что произошло, Пончик вообразил, что скафандр на нем лопнул, и это так напугало его, что он зашатался и начал валиться на бок"));

        // Незнайка заботливо поддержал его под руку и сказал: В это время воздух
        // окончательно вышел из шлюзовой камеры, и наружная дверь автоматически
        // отворилась.
        story.addFrase(new Frase(
                "Незнайка заботливо поддержал его под руку и сказал: В это время воздух окончательно вышел из шлюзовой камеры, и наружная дверь автоматически отворилась"));

        // Увидев блеснувший впереди свет, Незнайка скомандовал: Взявшись за руки,
        // друзья вышли из шлюзокамеры и, спустившись по лестничке, очутились на
        // поверхности Луны.
        story.addFrase(new Frase(
                "Увидев блеснувший впереди свет, Незнайка скомандовал: Взявшись за руки, друзья вышли из шлюзокамеры и, спустившись по лестничке, очутились на поверхности Луны"));

        // Картина, открывшаяся перед их глазами, привела их в трепет и восхищение.
        story.addFrase(new Frase("Картина, открывшаяся перед их глазами, привела их в трепет и восхищение"));

        // Внизу, у самых ног путешественников, расстилалась равнина, напоминавшая
        // неподвижно застывшую поверхность моря с неглубокими впадинами и отлого
        // поднимающимися буграми.
        story.addFrase(new Frase(
                "Внизу, у самых ног путешественников, расстилалась равнина, напоминавшая неподвижно застывшую поверхность моря с неглубокими впадинами и отлого поднимающимися буграми"));

        // Как и обычная морская вода, эта волнистая, как бы внезапно окаменевшая
        // поверхность Луны была зеленовато-голубого, или, как его принято называть,
        // аквамаринового цвета.
        story.addFrase(new Frase(
                "Как и обычная морская вода, эта волнистая, как бы внезапно окаменевшая поверхность Луны была зеленовато-голубого, или, как его принято называть, аквамаринового цвета"));

        // Вдали, позади этой зыбкой на вид поверхности, возвышались холмы.
        story.addFrase(new Frase("Вдали, позади этой зыбкой на вид поверхности, возвышались холмы"));

        // Они были желтые, словно песчаные.
        story.addFrase(new Frase("Они были желтые, словно песчаные"));
        // endregion

        // За холмами громоздились ярко-красные горы.
        story.addFrase(new Frase(
                FluidText.fluid(scene.getEnvinronment("ярко-красные горы"))
                        .doAction(new PiledUpAction())
                        .behindReversed(LabelDicrionary.Hills)
                        .getTextByFormatter(new ReverseFormatter())));

        {
            var flameTongues = FluidText.fluid(LabelDicrionary.Tongues)
                    .of(FluidText.fluid(new Name(LabelDicrionary.Flame).addModifier(ModifierDictionary.FrozenNeuter),
                            new Appearance(Property.Red, Property.Bright)));

            var comparisonResult = (ActionResultBinary) scene.getMainActor()
                    .doAction(new ComparedAlikeAction(scene.getEnvinronment("ярко-красные горы"), flameTongues));

            if (!comparisonResult.isPositive())
                throw new RuntimeException(scene.getEnvinronment("ярко-красные горы").getName() + " не похожи на "
                        + flameTongues.getName());

            // Они, словно языки застывшего пламени, взмывали кверху.
            story.addFrase(new Frase(
                    FluidText.fluid(scene.getEnvinronment("ярко-красные горы"))
                            .alike(flameTongues)
                            .doAction(new SoaredUpAction())
                            .getTextByFormatter(new PronounDirectFormatter())));
        }

        // region
        // По правую руку, невдалеке от наших путешественников, были такие же
        // огненно-красные горы.
        story.addFrase(
                new Frase("По правую руку, невдалеке от наших путешественников, были такие же огненно-красные горы"));

        // Они как бы вздымались со дна окаменевшего моря и тянулись своими заостренными
        // верхушками к небу.
        story.addFrase(new Frase(
                "Они как бы вздымались со дна окаменевшего моря и тянулись своими заостренными верхушками к небу"));

        // Обернувшись назад.
        story.addFrase(new Frase("Обернувшись назад"));

        // Незнайка и Пончик увидели вдали горы, имевшие более смутные очертания.
        story.addFrase(new Frase("Незнайка и Пончик увидели вдали горы, имевшие более смутные очертания"));

        // Казалось, они были словно из ваты и по своему виду напоминали лежавшие на
        // Земле облака.
        story.addFrase(
                new Frase("Казалось, они были словно из ваты и по своему виду напоминали лежавшие на Земле облака"));

        // На их вершинах и склонах, будто фантастические стеклянные замки, торчали
        // гигантские кристаллы, напоминавшие по форме кристаллы горного хрусталя.
        story.addFrase(new Frase(
                "На их вершинах и склонах, будто фантастические стеклянные замки, торчали гигантские кристаллы, напоминавшие по форме кристаллы горного хрусталя"));

        // Солнечный свет преломлялся в гранях этих кристаллов, благодаря чему они
        // сверкали всеми цветами радуги.
        story.addFrase(new Frase(
                "Солнечный свет преломлялся в гранях этих кристаллов, благодаря чему они сверкали всеми цветами радуги"));

        // Над всем этим причудливым миром, как бездонная пропасть, зияло черное небо с
        // мириадами крупных и мелких звезд.
        story.addFrase(new Frase(
                "Над всем этим причудливым миром, как бездонная пропасть, зияло черное небо с мириадами крупных и мелких звезд"));

        // Млечный Путь, словно светящаяся дорога, протянулся через всю эту бездну и
        // поделил ее на две части.
        story.addFrase(new Frase(
                "Млечный Путь, словно светящаяся дорога, протянулся через всю эту бездну и поделил ее на две части"));

        // В левой части, среди звезд, скопившихся над горизонтом, сверкало жгучее
        // Солнце.
        story.addFrase(new Frase("В левой части, среди звезд, скопившихся над горизонтом, сверкало жгучее Солнце"));

        // В правой половине светилась мягким зеленоватым светом планета Земля.
        story.addFrase(new Frase("В правой половине светилась мягким зеленоватым светом планета Земля"));

        // Она была освещена солнечными лучами сбоку и поэтому имела вид полумесяца.
        story.addFrase(new Frase("Она была освещена солнечными лучами сбоку и поэтому имела вид полумесяца"));

        // На фоне черного, зияющего пустотой неба вся поверхность Луны казалась
        // особенно яркой и красочной.
        story.addFrase(new Frase(
                "На фоне черного, зияющего пустотой неба вся поверхность Луны казалась особенно яркой и красочной"));

        // Этому способствовало также отсутствие вокруг Луны атмосферы, то есть,
        // попросту говоря, воздуха.
        story.addFrase(new Frase(
                "Этому способствовало также отсутствие вокруг Луны атмосферы, то есть, попросту говоря, воздуха"));

        // Как известно, воздух не только поглощает солнечные лучи, делая их менее
        // яркими, но и рассеивает их, смягчая тени, отбрасываемые предметами.
        story.addFrase(new Frase(
                "Как известно, воздух не только поглощает солнечные лучи, делая их менее яркими, но и рассеивает их, смягчая тени, отбрасываемые предметами"));

        // На Луне тени предметов всегда глубокие, темные, отчего сами предметы
        // выделяются более четко и выглядят ярче, красочнее.
        story.addFrase(new Frase(
                "На Луне тени предметов всегда глубокие, темные, отчего сами предметы выделяются более четко и выглядят ярче, красочнее"));

        // Неподалеку от скопления облачных гор возвышалась одинокая гора в виде темного
        // конуса или пирамиды.
        story.addFrase(new Frase(
                "Неподалеку от скопления облачных гор возвышалась одинокая гора в виде темного конуса или пирамиды"));

        // От ее подножия к пригорку, на который опустилась ракета, словно тоненький луч
        // протянулась дорожка.
        story.addFrase(new Frase(
                "От ее подножия к пригорку, на который опустилась ракета, словно тоненький луч протянулась дорожка"));

        // Она была светлая, будто кто-то нарочно посыпал в этом месте каменистую почву
        // Луны песком или мелом.
        story.addFrase(new Frase(
                "Она была светлая, будто кто-то нарочно посыпал в этом месте каменистую почву Луны песком или мелом"));

        // Не дожидаясь ответа, Незнайка зашагал бодрым шагом по направлению к лунной
        // дорожке.
        story.addFrase(new Frase("Не дожидаясь ответа, Незнайка зашагал бодрым шагом по направлению к лунной дорожке"));

        // Увидев, что он уже опоздал высказать свое мнение, Пончик развел руками и
        // покорно пошел за Незнайкой.
        story.addFrase(new Frase(
                "Увидев, что он уже опоздал высказать свое мнение, Пончик развел руками и покорно пошел за Незнайкой"));

        // endregion

        return story;
    }
}

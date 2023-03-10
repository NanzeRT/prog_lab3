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

        // ?????? ?????????? ?? ?????????????????? ???????????? ???????????????????? ?? ???????????? ?? ????????????????.
        story.addFrase(new Frase(
                FluidText.these(LabelDicrionary.Thoughts)
                        .with(FluidText.fluid(LabelDicrionary.Fastness).of(LabelDicrionary.Lightning))
                        .doAction(new SweptAction())
                        .in(FluidText.fluid(LabelDicrionary.Head)
                                .inU(scene.getMainActor()))
                        .getTextByFormatter(new DirectFormatter())));

        // ???? ???? ???? ???????????????? ????????????.
        story.addFrase(new Frase().but(
                FluidText.fluid(scene.getMainActor())
                        .doAction(new DidntSuccumbedAction(LabelDicrionary.Fear))
                        .getTextByFormatter(new PronounDirectFormatter())));

        // ?????? ???? ?????????? ???????????????????? ??????????????, ???? ?????????? ?????? ?????????? ?????????? ???? ??????????, ?? ????????????
        // ?????????? ?????????? ???????????? ?? ??????????.
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

        // ???? ?????????? ???? ??????????????????, ?????? ???????????? ????????????????.
        story.addFrase(new Frase().but(
                FluidText.fluid(LabelDicrionary.Door)
                        .doAction(new DidntOpenedItselfAction())
                        .getTextByFormatter(new DirectFormatter()))
                .as(FluidText.fluid(scene.getMainActor())
                        .doAction(new ExpectedAction())
                        .getTextByFormatter(new ReverseFormatter())));

        var littleHole = FluidText.fluid(new Name(LabelDicrionary.Hole).addModifier(ModifierDictionary.LittleNeuter));

        // ?????????????????? ???????? ?????????????????? ??????????????????, ?????????????????? ?? ??????????.
        story.addFrase(new Frase(
                littleHole.doAction(new OpenedItselfAction())
                        .getTextByFormatter(new ReverseFormatterWithInsert("????????")))
                .comma(littleHole.doAction(new WasAvailableAction())
                        .in(FluidText.fluid(LabelDicrionary.Door))
                        .getTextByFormatter(new NoNameFormatter())));

        // ???????????????????????? ???????????? ?????????? ?????????????????????? ?? ???????????????? ???????????????????????? ??????????????????????????,
        // ?? ????????????, ???????????????????????? ?? ???????????????? ????????????, ???? ?????????????? ?????????? ???????????????????? ????
        // ??????????????.
        story.addFrase(new Frase(
                FluidText.fluid(LabelDicrionary.Space)
                        .inside(LabelDicrionary.Gateway)
                        .doAction(new ActionWithTargetFromVerb(VerbDictionary.ConnectedWith,
                                FluidText.fluid(new Name(LabelDicrionary.Space)
                                        .addModifier(ModifierDictionary.OuterNeuter)
                                        .addModifier(ModifierDictionary.AirlessNeuter))))
                        .getTextByFormatter(new DirectFormatter()))
                // region
                .and("????????????, ???????????????????????? ?? ???????????????? ????????????, ???? ?????????????? ?????????? ???????????????????? ???? ??????????????"));

        // ???????????????? ?? ???????????? ??????????????????????????, ?????? ??????????????????????, ?????????????? ???????????? ????????????
        // ?????????????????? ?? ????????, ?????????? ???????????? ?????????????????????? ????????????????????, ???????????? ??????????????????????.
        story.addFrase(new Frase(
                "???????????????? ?? ???????????? ??????????????????????????, ?????? ??????????????????????, ?????????????? ???????????? ???????????? ?????????????????? ?? ????????, ?????????? ???????????? ?????????????????????? ????????????????????, ???????????? ??????????????????????"));

        // ?????? ?????????????????????? ??????, ?????? ???????????????? ?????????????????? ?????????????? ?????????????? ?? ????????????
        // ???????????????????? ?????????? ???????????????????? ???????? ???????????????? ?????????????? ??????????????.
        story.addFrase(new Frase(
                "?????? ?????????????????????? ??????, ?????? ???????????????? ?????????????????? ?????????????? ?????????????? ?? ???????????? ???????????????????? ?????????? ???????????????????? ???????? ???????????????? ?????????????? ??????????????"));

        // ???? ??????????, ?????? ??????????????????, ???????????? ??????????????????, ?????? ???????????????? ???? ?????? ????????????, ?? ??????
        // ?????? ???????????????? ??????, ?????? ???? ?????????????????? ?? ?????????? ???????????????? ???? ??????.
        story.addFrase(new Frase(
                "???? ??????????, ?????? ??????????????????, ???????????? ??????????????????, ?????? ???????????????? ???? ?????? ????????????, ?? ?????? ?????? ???????????????? ??????, ?????? ???? ?????????????????? ?? ?????????? ???????????????? ???? ??????"));

        // ???????????????? ?????????????????? ?????????????????? ?????? ?????? ???????? ?? ????????????: ?? ?????? ?????????? ????????????
        // ???????????????????????? ?????????? ???? ???????????????? ????????????, ?? ???????????????? ?????????? ??????????????????????????
        // ????????????????????.
        story.addFrase(new Frase(
                "???????????????? ?????????????????? ?????????????????? ?????? ?????? ???????? ?? ????????????: ?? ?????? ?????????? ???????????? ???????????????????????? ?????????? ???? ???????????????? ????????????, ?? ???????????????? ?????????? ?????????????????????????? ????????????????????"));

        // ???????????? ???????????????????? ?????????????? ????????, ???????????????? ??????????????????????: ???????????????? ???? ????????,
        // ???????????? ?????????? ???? ?????????????????????? ??, ?????????????????????? ???? ??????????????????, ?????????????????? ????
        // ?????????????????????? ????????.
        story.addFrase(new Frase(
                "???????????? ???????????????????? ?????????????? ????????, ???????????????? ??????????????????????: ???????????????? ???? ????????, ???????????? ?????????? ???? ?????????????????????? ??, ?????????????????????? ???? ??????????????????, ?????????????????? ???? ?????????????????????? ????????"));

        // ??????????????, ?????????????????????? ?????????? ???? ??????????????, ?????????????? ???? ?? ???????????? ?? ????????????????????.
        story.addFrase(new Frase("??????????????, ?????????????????????? ?????????? ???? ??????????????, ?????????????? ???? ?? ???????????? ?? ????????????????????"));

        // ??????????, ?? ?????????? ?????? ????????????????????????????????, ???????????????????????? ??????????????, ????????????????????????
        // ???????????????????? ?????????????????? ?????????????????????? ???????? ?? ?????????????????????? ?????????????????? ?? ????????????
        // ???????????????????????????? ??????????????.
        story.addFrase(new Frase(
                "??????????, ?? ?????????? ?????? ????????????????????????????????, ???????????????????????? ??????????????, ???????????????????????? ???????????????????? ?????????????????? ?????????????????????? ???????? ?? ?????????????????????? ?????????????????? ?? ???????????? ???????????????????????????? ??????????????"));

        // ?????? ?? ?????????????? ?????????????? ????????, ?????? ??????????????????, ?????? ???? ???????????????? ??????????????????????
        // ?????????????????????? ???????? ???????? ????????????????????-????????????????, ??????, ?????? ?????? ?????????????? ????????????????,
        // ???????????????????????????? ??????????.
        story.addFrase(new Frase(
                "?????? ?? ?????????????? ?????????????? ????????, ?????? ??????????????????, ?????? ???? ???????????????? ?????????????????????? ?????????????????????? ???????? ???????? ????????????????????-????????????????, ??????, ?????? ?????? ?????????????? ????????????????, ???????????????????????????? ??????????"));

        // ??????????, ???????????? ???????? ???????????? ???? ?????? ??????????????????????, ?????????????????????? ??????????.
        story.addFrase(new Frase("??????????, ???????????? ???????? ???????????? ???? ?????? ??????????????????????, ?????????????????????? ??????????"));

        // ?????? ???????? ????????????, ???????????? ????????????????.
        story.addFrase(new Frase("?????? ???????? ????????????, ???????????? ????????????????"));
        // endregion

        // ???? ?????????????? ???????????????????????? ????????-?????????????? ????????.
        story.addFrase(new Frase(
                FluidText.fluid(scene.getEnvinronment("????????-?????????????? ????????"))
                        .doAction(new PiledUpAction())
                        .behindReversed(LabelDicrionary.Hills)
                        .getTextByFormatter(new ReverseFormatter())));

        {
            var flameTongues = FluidText.fluid(LabelDicrionary.Tongues)
                    .of(FluidText.fluid(new Name(LabelDicrionary.Flame).addModifier(ModifierDictionary.FrozenNeuter),
                            new Appearance(Property.Red, Property.Bright)));

            var comparisonResult = (ActionResultBinary) scene.getMainActor()
                    .doAction(new ComparedAlikeAction(scene.getEnvinronment("????????-?????????????? ????????"), flameTongues));

            if (!comparisonResult.isPositive())
                throw new RuntimeException(scene.getEnvinronment("????????-?????????????? ????????").getName() + " ???? ???????????? ???? "
                        + flameTongues.getName());

            // ??????, ???????????? ?????????? ???????????????????? ??????????????, ???????????????? ????????????.
            story.addFrase(new Frase(
                    FluidText.fluid(scene.getEnvinronment("????????-?????????????? ????????"))
                            .alike(flameTongues)
                            .doAction(new SoaredUpAction())
                            .getTextByFormatter(new PronounDirectFormatter())));
        }

        // region
        // ???? ???????????? ????????, ?????????????????? ???? ?????????? ????????????????????????????????, ???????? ?????????? ????
        // ??????????????-?????????????? ????????.
        story.addFrase(
                new Frase("???? ???????????? ????????, ?????????????????? ???? ?????????? ????????????????????????????????, ???????? ?????????? ???? ??????????????-?????????????? ????????"));

        // ?????? ?????? ???? ???????????????????? ???? ?????? ???????????????????????? ???????? ?? ???????????????? ???????????? ????????????????????????
        // ???????????????????? ?? ????????.
        story.addFrase(new Frase(
                "?????? ?????? ???? ???????????????????? ???? ?????? ???????????????????????? ???????? ?? ???????????????? ???????????? ???????????????????????? ???????????????????? ?? ????????"));

        // ?????????????????????? ??????????.
        story.addFrase(new Frase("?????????????????????? ??????????"));

        // ???????????????? ?? ???????????? ?????????????? ?????????? ????????, ?????????????? ?????????? ?????????????? ??????????????????.
        story.addFrase(new Frase("???????????????? ?? ???????????? ?????????????? ?????????? ????????, ?????????????? ?????????? ?????????????? ??????????????????"));

        // ????????????????, ?????? ???????? ???????????? ???? ???????? ?? ???? ???????????? ???????? ???????????????????? ???????????????? ????
        // ?????????? ????????????.
        story.addFrase(
                new Frase("????????????????, ?????? ???????? ???????????? ???? ???????? ?? ???? ???????????? ???????? ???????????????????? ???????????????? ???? ?????????? ????????????"));

        // ???? ???? ???????????????? ?? ??????????????, ?????????? ???????????????????????????? ???????????????????? ??????????, ??????????????
        // ???????????????????? ??????????????????, ???????????????????????? ???? ?????????? ?????????????????? ?????????????? ????????????????.
        story.addFrase(new Frase(
                "???? ???? ???????????????? ?? ??????????????, ?????????? ???????????????????????????? ???????????????????? ??????????, ?????????????? ???????????????????? ??????????????????, ???????????????????????? ???? ?????????? ?????????????????? ?????????????? ????????????????"));

        // ?????????????????? ???????? ?????????????????????? ?? ???????????? ???????? ????????????????????, ?????????????????? ???????? ??????
        // ???????????????? ?????????? ?????????????? ????????????.
        story.addFrase(new Frase(
                "?????????????????? ???????? ?????????????????????? ?? ???????????? ???????? ????????????????????, ?????????????????? ???????? ?????? ???????????????? ?????????? ?????????????? ????????????"));

        // ?????? ???????? ???????? ?????????????????????? ??????????, ?????? ?????????????????? ????????????????, ?????????? ???????????? ???????? ??
        // ?????????????????? ?????????????? ?? ???????????? ??????????.
        story.addFrase(new Frase(
                "?????? ???????? ???????? ?????????????????????? ??????????, ?????? ?????????????????? ????????????????, ?????????? ???????????? ???????? ?? ?????????????????? ?????????????? ?? ???????????? ??????????"));

        // ?????????????? ????????, ???????????? ???????????????????? ????????????, ???????????????????? ?????????? ?????? ?????? ???????????? ??
        // ?????????????? ???? ???? ?????? ??????????.
        story.addFrase(new Frase(
                "?????????????? ????????, ???????????? ???????????????????? ????????????, ???????????????????? ?????????? ?????? ?????? ???????????? ?? ?????????????? ???? ???? ?????? ??????????"));

        // ?? ?????????? ??????????, ?????????? ??????????, ?????????????????????? ?????? ????????????????????, ???????????????? ????????????
        // ????????????.
        story.addFrase(new Frase("?? ?????????? ??????????, ?????????? ??????????, ?????????????????????? ?????? ????????????????????, ???????????????? ???????????? ????????????"));

        // ?? ???????????? ???????????????? ?????????????????? ???????????? ?????????????????????? ???????????? ?????????????? ??????????.
        story.addFrase(new Frase("?? ???????????? ???????????????? ?????????????????? ???????????? ?????????????????????? ???????????? ?????????????? ??????????"));

        // ?????? ???????? ???????????????? ???????????????????? ???????????? ?????????? ?? ?????????????? ?????????? ?????? ????????????????????.
        story.addFrase(new Frase("?????? ???????? ???????????????? ???????????????????? ???????????? ?????????? ?? ?????????????? ?????????? ?????? ????????????????????"));

        // ???? ???????? ??????????????, ???????????????? ???????????????? ???????? ?????? ?????????????????????? ???????? ????????????????
        // ???????????????? ?????????? ?? ??????????????????.
        story.addFrase(new Frase(
                "???? ???????? ??????????????, ???????????????? ???????????????? ???????? ?????? ?????????????????????? ???????? ???????????????? ???????????????? ?????????? ?? ??????????????????"));

        // ?????????? ???????????????????????????? ?????????? ???????????????????? ???????????? ???????? ??????????????????, ???? ????????,
        // ???????????????? ????????????, ??????????????.
        story.addFrase(new Frase(
                "?????????? ???????????????????????????? ?????????? ???????????????????? ???????????? ???????? ??????????????????, ???? ????????, ???????????????? ????????????, ??????????????"));

        // ?????? ????????????????, ???????????? ???? ???????????? ?????????????????? ?????????????????? ????????, ?????????? ???? ??????????
        // ????????????, ???? ?? ???????????????????? ????, ?????????????? ????????, ?????????????????????????? ????????????????????.
        story.addFrase(new Frase(
                "?????? ????????????????, ???????????? ???? ???????????? ?????????????????? ?????????????????? ????????, ?????????? ???? ?????????? ????????????, ???? ?? ???????????????????? ????, ?????????????? ????????, ?????????????????????????? ????????????????????"));

        // ???? ???????? ???????? ?????????????????? ???????????? ????????????????, ????????????, ???????????? ???????? ????????????????
        // ???????????????????? ?????????? ?????????? ?? ???????????????? ????????, ??????????????????.
        story.addFrase(new Frase(
                "???? ???????? ???????? ?????????????????? ???????????? ????????????????, ????????????, ???????????? ???????? ???????????????? ???????????????????? ?????????? ?????????? ?? ???????????????? ????????, ??????????????????"));

        // ???????????????????? ???? ?????????????????? ???????????????? ?????? ?????????????????????? ???????????????? ???????? ?? ???????? ??????????????
        // ???????????? ?????? ????????????????.
        story.addFrase(new Frase(
                "???????????????????? ???? ?????????????????? ???????????????? ?????? ?????????????????????? ???????????????? ???????? ?? ???????? ?????????????? ???????????? ?????? ????????????????"));

        // ???? ???? ???????????????? ?? ????????????????, ???? ?????????????? ???????????????????? ????????????, ???????????? ?????????????????? ??????
        // ?????????????????????? ??????????????.
        story.addFrase(new Frase(
                "???? ???? ???????????????? ?? ????????????????, ???? ?????????????? ???????????????????? ????????????, ???????????? ?????????????????? ?????? ?????????????????????? ??????????????"));

        // ?????? ???????? ??????????????, ?????????? ??????-???? ?????????????? ?????????????? ?? ???????? ?????????? ???????????????????? ??????????
        // ???????? ???????????? ?????? ??????????.
        story.addFrase(new Frase(
                "?????? ???????? ??????????????, ?????????? ??????-???? ?????????????? ?????????????? ?? ???????? ?????????? ???????????????????? ?????????? ???????? ???????????? ?????? ??????????"));

        // ???? ?????????????????? ????????????, ???????????????? ?????????????? ???????????? ?????????? ???? ?????????????????????? ?? ????????????
        // ??????????????.
        story.addFrase(new Frase("???? ?????????????????? ????????????, ???????????????? ?????????????? ???????????? ?????????? ???? ?????????????????????? ?? ???????????? ??????????????"));

        // ????????????, ?????? ???? ?????? ?????????????? ?????????????????? ???????? ????????????, ???????????? ???????????? ???????????? ??
        // ?????????????? ?????????? ???? ??????????????????.
        story.addFrase(new Frase(
                "????????????, ?????? ???? ?????? ?????????????? ?????????????????? ???????? ????????????, ???????????? ???????????? ???????????? ?? ?????????????? ?????????? ???? ??????????????????"));

        // endregion

        return story;
    }
}

package org.itmo.prog.lab3.dictionaries;

import org.itmo.prog.lab3.models.text.Case;
import org.itmo.prog.lab3.models.text.Verb;
import org.itmo.prog.lab3.models.text.VerbWithTarget;

public class VerbDictionary {
    public static Verb Raced = new Verb("пронёсся", "пронеслась", "пронеслось", "пронеслись", "пронесясь", "пронестись",
            Verb.TimeForm.PAST);
    public static Verb OpenedItself = new Verb("открылся", "открылась", "открылось", "открылись", "открывшись",
            "открыться", Verb.TimeForm.PAST);
    public static Verb Expected = new Verb("ожидал", "ожидала", "ожидало", "ожидали", "ожидая", "ожидать",
            Verb.TimeForm.PAST);
    public static Verb WasAvailable = new Verb("имевшийся", "имевшаяся", "имевшееся", "имевшиеся", "имевшись",
            "иметься", Verb.TimeForm.PAST);
    public static Verb Located = new Verb("находившийся", "находившаяся", "находившееся", "находившиеся", "нахдясь",
            "находиться", Verb.TimeForm.PAST);
    public static Verb WasEscaping = new Verb("вырывался", "вырывалась", "вырывалось", "вырывались", "вырываясь",
            "вырываться", Verb.TimeForm.PAST);
    public static Verb PiledUp = new Verb("громоздился", "громоздилась", "громоздилось", "громоздились", "громоздясь",
            "громоздиться", Verb.TimeForm.PAST);
    public static Verb SoaredUp = new Verb("взмывал кверху", "взмывала кверху", "взмывало кверху", "взмывали кверху",
            "взмывая кверху", "взмывать кверху", Verb.TimeForm.PAST);

    public static VerbWithTarget Succumbed = new VerbWithTarget("поддался", "поддалась", "поддалось", "поддались",
            "поддавшись", "поддаться", Verb.TimeForm.PAST, Case.DATIVE);
    public static VerbWithTarget CheeredUp = new VerbWithTarget("подбодрил", "подбодрила", "подбодрило", "подбодрили",
            "подбодрив", "подбодрить", Verb.TimeForm.PAST, Case.ACCUSATIVE);
    public static VerbWithTarget Wanted = new VerbWithTarget("желал", "желала", "желало", "желали", "желая", "желать",
            Verb.TimeForm.PAST, Case.ACCUSATIVE);
    public static VerbWithTarget Hugged = new VerbWithTarget("обнял", "обняла", "обняло", "обняли", "обняв", "обнять",
            Verb.TimeForm.PAST, Case.ACCUSATIVE);
    public static VerbWithTarget Pressed = new VerbWithTarget("нажал", "нажала", "нажало", "нажали", "нажав", "нажать",
            Verb.TimeForm.PAST, Case.ACCUSATIVE);
    public static VerbWithTarget ConnectedWith = new VerbWithTarget("соединился с", "соединилась с", "соединилось с",
            "соединились с", "соединившись с", "соединиться с", Verb.TimeForm.PAST, Case.INSTRUMENTAL);
    public static VerbWithTarget Started = new VerbWithTarget("начал", "начала", "начало", "начали", "начав", "начать",
            Verb.TimeForm.PAST, Case.ACCUSATIVE);
    public static VerbWithTarget Compared = new VerbWithTarget("сравнил", "сравнила", "сравнило", "сравнили", "сравнив",
            "сравнить", Verb.TimeForm.PAST, Case.ACCUSATIVE);
}

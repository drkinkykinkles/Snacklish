package com.drkinkykinkles.snacklish

val BlackList = hashSetOf(
    "the",
    "of",
    "and",
    "a",
    "to",
    "in",
    "is",
    "you",
    "that",
    "it",
    "it's",
    "it'll",
    "it'd",
    "he",
    "he's",
    "he'll",
    "he'd",
    "she",
    "she's",
    "she'll",
    "she'd",
    "was",
    "for",
    "on",
    "are",
    "as",
    "with",
    "his",
    "they",
    "they're",
    "they've",
    "they'll",
    "they'd",
    "i",
    "i'm",
    "i've",
    "i'll",
    "i'd",
    "you",
    "you've",
    "you'd",
    "at",
    "be",
    "this",
    "from",
    "or",
    "by",
    "what",
    "me"
)

val FixedList = mapOf(
    "say" to "saytisfy",
    "better" to "treatter",
    "there" to "treatere",
    "if" to "fill",
    "you're" to "youchewer",
    "true" to "chew",
    "us" to "chews",
    "use" to "chewse",
    "now" to "chow",
    "make" to "caramakel",
    "know" to "knougat",
    "no" to "nougat",
    "meme" to "yume",
    "my" to "yumy",
    "yes" to "yumye",
    "snake" to "snack",
    "little" to "snackittle",
    "sucked" to "snacked",
    "six" to "snax",
    "storm" to "snackstorm",
    "kill" to "hungercide",
    "war" to "whunger",
    "man" to "hungerman",
    "tongue" to "tonguegry",
    "noone" to "chocone",
    "got" to "chocot",
    "hope" to "chocopelate",
    "been" to "beenut",
    "can" to "canut",
    "much" to "nutuch",
    "pawn" to "pawnuts",
    "none" to "nutte",
    "regret" to "nutgret",
    "must" to "nuts",
    "nine" to "ninut",
    "bare" to "bar",
    "think" to "chomptemplate",
    "time" to "chomptime",
    "create" to "crunch",
    "created" to "crunched",
    "dead" to "fed",
    "seven" to "sweetven",
    "so" to "soweet",
    "eat" to "wait",
    "body" to "candy",
    "full" to "mouthfull",
    "her" to "flaveher",
    "four" to "flavefour",
    "worst" to "flavorst",
    "give" to "goodive",
    "pretty" to "prettytasty",
    "take" to "takesty",
    "state" to "substateial",
    "hidden" to "hiddenjoy",
    "have" to "havisfaction"
)

val RuleList = mapOf(
    //Bite
    "[bcdfghjklmnpqrstvwxz](ight|ite)" to "bite", // consonant + ight or ite, replace with "bite"

    //Chocolate
    "(ck|x)\\b" to "$0olate", //append "olate" to ending ck or x
    "\\b(co|cl|go)" to "cho$0", //prepend cho to starting co, cl, or go
    "\\bo" to "choco", //starting o to choco

    //Treat
    "t\\b" to "$0reat", //append "reat" to words ending with t
    "ts\\b" to "treats", //if the word ends with "ts", replace with "treats"
    "tr" to "treat", //if "tr" is found in a word, replace with "treat"

    //Satisfaction
    "\\bs" to "sati$0", //if the word starts with an s, prepend "sati"
    "\\b[fpwln]" to "satis$0", //if the word begins with a f, p, w, l, n, prepend "satis"
    "\\b[bcdfghjklmnpqrstvwxz]is" to  "satis", //if the word begins with any consonant followed by "is", replace with "satis" (miserable => satiserable)

    //Delicious
    "[aeiouyr]\\b" to "$0licious", //if the word ends with any vocal or r, append "licious"
    "es\\b" to "elicious", //if the word ends in es, replace with "elicious"

    //Satisfaction
    "[ts]\\b" to "$0isfaction", //if the word ends in t or s, append "isfaction"
    "er\\b" to "isfaction", //if the word ends in er, replace with "isfaction"
    "\\b[bcdfghjklmnpqrstvwxz]ark\\b" to "satis$0tion", //if the word is made up of a consonant followed by "ark" (i.e. dark), prepend "sati" and append "tion".
    "ve\\b" to "visfaction", //if the word ends in ve, replace with "visfaction"

    //Indulge
    "\\bin" to "indulg", //starting in to indulg
    "\\bd" to "induld", //starting d to induld
    "in\\b" to "indulge", //ending in to indulge

    //Candy
    "\\bany" to "candy", //starting any to candy

    //Eat
    "ing\\b" to "eat", //ending ing to eat
    "\\bext" to "eats", //starting ext to eat

    //Bar
    "\\b(b[e]?|pre|[cdfghjklmnopqrstvwxz]ar)" to "bar", //starting b/be/pre and car/dar/far/etc... to bar

    //Chomp
    "\\b(comp|sop?|o?p)" to "chomp", //starting p/op/sop/comp to chomp

    //Crunch
    "\\bcont" to "crunch", //starting cont to crunch

    //Peanut
    "p\\b" to "peanut", //ending p to peanut

    //Delectable
    "\\bbl?" to "delecta$0", //prepend delecta to starting b/bl
    "(ds?|l)\\b" to "delectable", //ending d(s) or l to delectable

    //Snack
    "\\b[bcdfghjklmnpqrstwxz]?[ae](ck|k|c|g|t)" to "snack", //starting optional consonant + a/e + ck/k/c/g/t to snack
    "\\b[k]" to "snack", //starting k to snack

    //Caramel
    "\\bl" to "caramel", //starting l to caramel
    "l\\b" to "lamel", //ending l to lamel
    "\\b[bcdfghjklmnpqrstvwxz]?(a|e|i)(l|n)" to "caram$1$2", //optional starting consonant + a/e/i + l/n, prepend "caram". Examples: always/caramalways, well/caramell, million/caramillion
    "med\\b" to "meled", //ending med to meled, sounds more related to marmalade than caramel though

    //Hunger
    "\\bre" to "hungry", //starting re to hungry
    "\\b(r|gr)" to "hunger", //starting r or gr to hunger

    //Yum
    "\\b(m|hun|hum)" to "yum", //starting m, hun, or hum to yum
    "(em|eam)" to "eyum", //em or eam to eyum

    //Fill
    "\\b[bcdfghjklmnpqrstvwxz]{0,3}(al+|il+|el+)" to "fill", //replace up to three initial consonants and the following al, il, or el (with any number of l's) with fill
    "ls\\b" to "fills", //if the word ends in ls, replace with fills

    //Nougat
    "\\bt" to "nougat", //starting t to nougat
    "\\bg" to  "noug", //starting g to to noug
    "n\\b" to "nougat", //ending n to nougat
    "\\b[bcdfghjklmnpqrstvwxz]ag" to "noug", //starting consonant + ag to noug
    "\\bar" to "nougar", //starting ar to nougar
    "\\bnu\\b" to "nougat", //middling nu to nougat

    //Chew
    "\\bus" to "chews", //replace starting "us" with "chews"
    "\\bw" to "chew", //starting w to chew
    "\\bup" to "chewp", //starting up to chewp
    "\\btr" to "chewr", //replace starting "tr" with "chewr"
    "\\bun" to "chewn", //starting un to chewn
    "tur" to "chewer", //replace "tur" with "chewer"
    "[c^](do|ru|tw|hu|qu|tu|eu)" to "chew", //replace do, ru, tw, hu, qu, tu, eu, with chew

    //Chow
    "[bcdfghjklmnpqrstvwxz](ow|aw)" to "chow", //replace any consonant + aw or ow with chow

    //Nuts
    "net|not" to "nut", //net/not to nut
    "ous" to "nuts", //ous/nt nut
    "nt\\b" to "nut", //ending nt to nut
    "nt" to "nutt", //nt to nutt
    "\\bun" to "nut", //starting un to nut
    "t\\b" to "nut" //ending t to nut
)
package sample.Dictionaries;

import sample.Enums.TraitEnum;

public class TraitDictionary {
    public static int resolveTrait(TraitEnum t){
        int cost = 0;
        switch(t){
            case FOOD_MINUS_1:
                cost = -2;
                break;
            case FOOD_PLUS_1:
                cost = 2;
                break;
            case FOOD_PLUS_2:
                cost = 5;
                break;
            case PROD_MINUS_1:
                cost = -2;
                break;
            case PROD_PLUS_1:
                cost = 2;
                break;
            case PROD_PLUS_2:
                cost = 5;
                break;
            case SCI_MINUS_1:
                cost = -2;
                break;
            case SCI_PLUS_1:
                cost = 2;
                break;
            case SCI_PLUS_2:
                cost = 5;
                break;
            case INF_MINUS_1:
                cost = -2;
                break;
            case INF_PLUS_1:
                cost = 2;
                break;
            case INF_PLUS_2:
                cost = 5;
                break;
            case CYBORG:
                cost = 5;
                break;
            case PSIONIC:
                cost = 6;
                break;
            case WARRIORS:
                cost = 4;
                break;
            case MECHANICAL:
                cost = 8;
                break;
            case AQUATIC:
                cost = 6;
                break;
            case LITHOVORE:
                cost = 7;
                break;
            case ADAPTABLE:
                cost = 6;
                break;
            case CONTENT:
                cost = 4;
                break;

        }
        System.out.println("cost: "+ cost);
        System.out.println("trait: "+ t.toString());

        return cost;
    }
}

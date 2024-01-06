package src.model;

import java.util.*;


public class Skills {
    private final Set <String> stSkills;

    public Skills(){
        this.stSkills = new HashSet<>();

    }

    public void setStSkills(List<String> aSkills) {
        aSkills.forEach( n -> { String str0 = n.trim();  if(str0.length()>0) this.stSkills.add(str0); });
    }

    public void setStSkills(String aSkills) {  // https://stackoverflow.com/questions/7488643/how-to-convert-comma-separated-string-to-list
        List<String> items = Arrays.asList(aSkills.split("\\s*(,\\s*)+"));
        // List<String> items0 = Lists.newArrayList(Splitter.on(",").trimResults().split(aSkills) );  // guava
        /*
        That regex "\\s*,\\s*" means:
        \s* any number of whitespace characters
        a comma
        \s* any number of whitespace characters
        which will split on commas and consume any spaces either side

        http://www.regular-expressions.info/shorthand.html

        https://stackoverflow.com/questions/7488643/how-to-convert-comma-separated-string-to-list
        "\\s*(,\\s*)+"    "\\s*,\\s*"

        List<String> list = Lists.newArrayList(Splitter.on(",").trimResults().split(string) );

        https://github.com/google/guava
        */

        // items.forEach( n -> { String str0 = n;  if( str0.length()>0 ) this.stSkills.add( str0 ); }); // not work
        items.forEach( n -> { String str0 = n.trim();  if( str0.length()>0 ) this.stSkills.add( str0 ); });  // String.trim
    }

    public Set<String> getStSkills() {
        return stSkills;
    }

    @Override
    public String toString() {

        List<String> list = new ArrayList<>(this.stSkills);
        Collections.sort(list);
        String str0 = list.toString();
        StringBuilder sb = new StringBuilder(str0);
        sb.deleteCharAt(0);  sb.deleteCharAt(str0.length()-2); // delete []
        return sb.toString();
    }

    public static void main(String[] args) {
        //  System.out.println(String.format("PERSON_QUERY  : %s", PERSON_QUERY));

        System.out.println("Hello  sKILLS !!");
        Skills aSkills = new Skills();
        aSkills.setStSkills(" ");
        aSkills.setStSkills(" сидеть  ,     ,,,, голос    , фас ");
        aSkills.setStSkills(List.of("qaz", "wsx", "edc"));
        aSkills.setStSkills(List.of("qaz", "wsx007", "edc"));
        aSkills.setStSkills(List.of("сидеть", "голос", "фас"));

        aSkills.setStSkills(" сидеть , голос  , фас ");

        System.out.println(aSkills);

    }

}

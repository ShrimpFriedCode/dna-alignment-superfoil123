/**
 * This class is used to score alignments.
 *  
 */

public class Judge {

  public static final int DEFAULT_MATCH_COST = 2;
  public static final int DEFAULT_MISMATCH_COST = -2;
  public static final int DEFAULT_GAP_COST = -1;
  
  private int matchCost, mismatchCost, gapCost;
  
  /**
   * Creates the default judge.
   */
  public Judge() {
    this(DEFAULT_MATCH_COST, DEFAULT_MISMATCH_COST, DEFAULT_GAP_COST);
  }
  
  /**
   * Creates a judge using the specified costs.
   */
  public Judge(int matchCost, int mismatchCost, int gapCost) {
    this.matchCost = matchCost;
    this.mismatchCost = mismatchCost;
    this.gapCost = gapCost;
  }
  
  /**
   * Returns the gap cost used by this judge.
   */
  public int getGapCost() {
    return gapCost;
  }
  
  /**
   * Returns the match cost used by this judge.
   */
  public int getMatchCost() {
    return matchCost;
  }
  
  /**
   * Returns the mismatch cost used by this judge.
   */
  public int getMismatchCost() {
    return mismatchCost;
  }
  
  /**
   * Returns the score associated with the two characters.
   */
  public int score(char a, char b) {
    int ret = 0;

    if(a == b && !((a == '_') || (b == '_'))){
      ret += this.matchCost;
    }
    else if((a == '_') || (b == '_')){
      ret += this.gapCost;
    }
    else{
      ret += this.mismatchCost;
    }
    return ret;
  }

  /**
   * Returns the score associated with the two strings.
   */
  public int score(String s1, String s2) {

    char[] s1arr = s1.toCharArray();
    char[] s2arr = s2.toCharArray();

    int ret = 0;

    for(int i = 0; i < s1arr.length; i++){

      if(s1arr[i] == s2arr[i] && !((s1arr[i] == '_') || (s2arr[i] == '_'))){
        ret += this.matchCost;
      }
      else if((s1arr[i] == '_') || (s2arr[i] == '_')){
        ret += this.gapCost;
      }
      else{
        ret += this.mismatchCost;
      }
    }
    return ret;
  }

}

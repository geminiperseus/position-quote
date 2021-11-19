
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Position implements Comparable<Position> {
    private String accountId;
    private String symbol;
    private long numShares;
    public Position(String positionStr) {
        String [] tokens = positionStr.split(",");
        this.accountId = tokens[0];
        this.symbol = tokens[1];
        this.numShares = Long.valueOf(tokens[2]);
    }
    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String sym) {
        this.symbol = sym;
    }
    public long getNumberOfShares() {
        return numShares;
    }
    public void setNumberOfShares(long shares) {
        this.numShares = shares;
    }
    @Override
    public String toString() {
        return String.format("Position [accountId=%s, symbol=%s, numShares=%s]", accountId, symbol, numShares);
    }

    @Override
    public int compareTo(Position o) {
        return this.getAccountId().compareTo(o.getAccountId());
    }
}
class Quote implements Comparable<Quote>{
    private String symbol;
    private BigDecimal price;
    public Quote(String quoteStr) {
        String [] tokens = quoteStr.split(",");
        this.symbol = tokens[0];
        this.price = new BigDecimal(tokens[1]);
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String sym) {
        this.symbol = sym;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Quote [symbol=%s, price=%s]", symbol, price);
    }

    @Override
    public int compareTo(Quote o) {
        return this.getSymbol().compareTo(o.getSymbol());
    }
}
class PositionSvc {
    private List<Position> positions;
    public PositionSvc() {
        this.positions = new ArrayList<>();
        this.positions.add(new Position("4810b949,SHW,10"));
        this.positions.add(new Position("286ea600,LEG,75"));
        this.positions.add(new Position("286ea600,SHW,7"));
        this.positions.add(new Position("3a8f7d92,CAH,52"));
        this.positions.add(new Position("3a8f7d92,OTIS,110"));
        this.positions.add(new Position("286ea600,VFC,84"));
        this.positions.add(new Position("3a8f7d92,PEP,26"));
        this.positions.add(new Position("3a8f7d92,GD,44"));
        this.positions.add(new Position("3a8f7d92,SHW,4"));
        this.positions.add(new Position("b949203a,BDX,28"));
        this.positions.add(new Position("b949203a,VFC,55"));
        this.positions.add(new Position("3a8f7d92,MCD,23"));
        this.positions.add(new Position("8f7d928a,VFC,77"));
        this.positions.add(new Position("8f7d928a,KMB,31"));
        this.positions.add(new Position("8f7d928a,MCD,10"));
        this.positions.add(new Position("b949203a,SHW,7"));
        this.positions.add(new Position("b949203a,WMT,48"));
        this.positions.add(new Position("8f7d928a,BDX,13"));
        this.positions.add(new Position("b949203a,ROP,13"));
        this.positions.add(new Position("b949203a,LEG,105"));
        this.positions.add(new Position("286ea600,PEP,25"));
        this.positions.add(new Position("3a8f7d92,VFC,35"));
        this.positions.add(new Position("8f7d928a,NUE,81"));
        this.positions.add(new Position("286ea600,ECL,23"));
        this.positions.add(new Position("3a8f7d92,FRT,30"));
        this.positions.add(new Position("4810b949,DOV,29"));
        this.positions.add(new Position("8f7d928a,FRT,83"));
        this.positions.add(new Position("8f7d928a,SHW,10"));
        this.positions.add(new Position("4810b949,LEG,59"));
        this.positions.add(new Position("b949203a,FRT,80"));
        this.positions.add(new Position("286ea600,WMT,35"));
        this.positions.add(new Position("4810b949,KMB,32"));
        this.positions.add(new Position("4810b949,ECL,11"));
        this.positions.add(new Position("b949203a,KMB,34"));
        this.positions.add(new Position("4810b949,PBCT,469"));
        this.positions.add(new Position("8f7d928a,LEG,71"));
        this.positions.add(new Position("3a8f7d92,WMT,40"));
        this.positions.add(new Position("286ea600,PBCT,223"));
        this.positions.add(new Position("8f7d928a,T,118"));
        this.positions.add(new Position("4810b949,NUE,131"));
        this.positions.add(new Position("286ea600,GD,15"));
        this.positions.add(new Position("286ea600,MCD,22"));
        this.positions.add(new Position("286ea600,FRT,65"));
        this.positions.add(new Position("8f7d928a,DOV,27"));
        this.positions.add(new Position("8f7d928a,HRL,53"));
        this.positions.add(new Position("b949203a,MCD,14"));
        this.positions.add(new Position("3a8f7d92,PBCT,357"));
        this.positions.add(new Position("4810b949,CAH,61"));
        this.positions.add(new Position("8f7d928a,ECL,24"));
        this.positions.add(new Position("b949203a,DOV,38"));
        this.positions.add(new Position("8f7d928a,GD,41"));
        this.positions.add(new Position("3a8f7d92,ABBV,70"));
        this.positions.add(new Position("8f7d928a,PBCT,551"));
        this.positions.add(new Position("3a8f7d92,T,138"));
    }
    public List<Position> getCustomerPositions() {
        return this.positions;
    }
}
class QuoteSvc {
    private List<Quote> previousCloseQuotes;
    public QuoteSvc() {
        this.previousCloseQuotes = new ArrayList<>();
        this.previousCloseQuotes.add(new Quote("ABBV,91.87"));
        this.previousCloseQuotes.add(new Quote("BDX,233.54"));
        this.previousCloseQuotes.add(new Quote("CAH,49.30"));
        this.previousCloseQuotes.add(new Quote("DOV,109.26"));
        this.previousCloseQuotes.add(new Quote("ECL,204.96"));
        this.previousCloseQuotes.add(new Quote("FRT,81.83"));
        this.previousCloseQuotes.add(new Quote("GD,151.24"));
        this.previousCloseQuotes.add(new Quote("HRL,50.81"));
        this.previousCloseQuotes.add(new Quote("JNJ,147.97"));
        this.previousCloseQuotes.add(new Quote("KMB,150.74"));
        this.previousCloseQuotes.add(new Quote("LEG,41.73"));
        this.previousCloseQuotes.add(new Quote("MCD,211.79"));
        this.previousCloseQuotes.add(new Quote("NUE,46.91"));
        this.previousCloseQuotes.add(new Quote("OTIS,60.99"));
        this.previousCloseQuotes.add(new Quote("PBCT,10.86"));
        this.previousCloseQuotes.add(new Quote("PEP,138.33"));
        this.previousCloseQuotes.add(new Quote("ROP,419.45"));
        this.previousCloseQuotes.add(new Quote("SHW,666.77"));
        this.previousCloseQuotes.add(new Quote("T,29.44"));
        this.previousCloseQuotes.add(new Quote("VFC,68.15"));
        this.previousCloseQuotes.add(new Quote("WMT,141.15"));
        this.previousCloseQuotes.add(new Quote("XOM,38.88"));
    }
    public List<Quote> getAllPreviousClose() {
        return this.previousCloseQuotes;
    }
}

class MyInterClass {
    String accId;
    double total;

    public MyInterClass(String accId, double total) {
        this.accId = accId;
        this.total = total;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

public class QuoteSolution {
    public static void main(String args[] ) throws Exception {
        PositionSvc positionSvc = new PositionSvc();
        List<Position> plist = positionSvc.getCustomerPositions();
        QuoteSvc quoteSvc = new QuoteSvc();
        List<Quote> qlist = quoteSvc.getAllPreviousClose();
        System.out.println(getResults(plist, qlist));
        System.out.println(getResultsUsingStream(plist, qlist));

    }

    public static Map<String, Double> getResultsUsingStream(List<Position> p, List<Quote> q) {
        //Collections.sort(p);
        //Collections.sort(q);

        Map<String, Double> map = p.stream().flatMap(position-> q.stream()
                .filter(quote-> quote.getSymbol().equals(position.getSymbol()))
                .map(quote -> new MyInterClass(position.getAccountId(), quote.getPrice().multiply(BigDecimal.valueOf(position.getNumberOfShares())).doubleValue())))
                .collect(Collectors.groupingBy(pair -> pair.getAccId(), Collectors.summingDouble(pair->pair.getTotal())));


        //Map<String, Double> map = obj.stream().collect(Collectors.groupingBy(pair -> pair.getAccId(), Collectors.summingDouble(pair->pair.getTotal())));
        Map<String, Double> reverseSortedMap = new TreeMap<String, Double>(Collections.reverseOrder());
        reverseSortedMap.putAll(map);

        return reverseSortedMap;
    }

    public static List<String> getResults(List<Position> p, List<Quote> q) {
        Collections.sort(p);
        Collections.sort(q);

        Map<String, List<Position>> positionMap = p.stream().collect(Collectors.groupingBy(position-> position.getAccountId()));

        List<String> retList = new ArrayList<>();

        for (String pByA: positionMap.keySet()) {
            BigDecimal total = BigDecimal.ZERO;
            for (Position po: positionMap.get(pByA)) {
                for (Quote qu: q) {
                    if (po.getSymbol().equals(qu.getSymbol())) {
                        BigDecimal shareValue = BigDecimal.valueOf(po.getNumberOfShares()).multiply(qu.getPrice());
                        total = total.add(shareValue);
                    }
                }
            }
            retList.add(pByA+":"+total);
            total = BigDecimal.ZERO;
        }
        Collections.reverse(retList);
        return retList;
    }
}


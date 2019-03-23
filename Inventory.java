
import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private static Inventory single_instance = null;

    public Map<Item, Integer> inventory;
    public Map<Item, Integer>  questItems;
    public Map<Item, Integer>  normalItems;

    int maxSize;

    public Map<Item, Integer> getQuestItems() {
        return questItems;
    }

    public void setQuestItems(Map<Item, Integer> questItems) {
        this.questItems = questItems;
    }

    public Map<Item, Integer> getNormalItems() {
        return normalItems;
    }

    public void setNormalItems(Map<Item, Integer> normalItems) {
        this.normalItems = normalItems;
    }

    public int getMaxSize() {
        return maxSize;
    }

    // Set Size depending on LEVEL
    public void setMaxSize(int maxSize) {

        this.maxSize = maxSize;
    }

    private Item lastItemCollected;

    public void initialtize(int size) {
        inventory = new HashMap<>();
        questItems = new HashMap<>();
        normalItems = new HashMap<>();
    }



    public static Inventory getInstance()
    {
        if (single_instance == null)
            single_instance = new Inventory();


        return single_instance;
    }

    public Item LastItemCollected() {
        return lastItemCollected;
    }

    private void updateQuestAndNormal(Item i,int newQuantity) {
        if(i.IsQuestItem()) {
            if (newQuantity > 0 )
                questItems.put(i,newQuantity);
            else
                questItems.remove(newQuantity);
        } else {
            if (newQuantity > 0 )
                normalItems.put(i,newQuantity);
            else
                normalItems.remove(newQuantity);
        }
    }


    public void getitem(Item i, int quantity) {
        if (!checkMaxInventory())
            return;
        int newQuantity = 0;
        if(inventory.containsKey(i)) {
            newQuantity = inventory.get(i) + quantity;
            inventory.put(i, newQuantity);
        } else {
            newQuantity = quantity;
            inventory.put(i, quantity);
        }

        updateQuestAndNormal(i,quantity);

        AchievementsSystem.instance.DidModifyItem("gain",i.identifier,quantity);
        didpickupitem(i);
    }

    public void loseitem(Item i, int quantity) {
        if(!checkMaxInventory())
            return;
        int newQuantity = 0;
        if(inventory.containsKey(i)) {
            newQuantity = inventory.get(i) - quantity;
            if (newQuantity > 0)
                inventory.put(i, newQuantity);
            else
                inventory.remove(i);

            updateQuestAndNormal(i,quantity);
        } else {
            return;
        }

        if(i.IsQuestItem()) {
            questItems.put(i,newQuantity);
        } else {
            normalItems.put(i,newQuantity);
        }
        int previousQuantity = inventory.get(i);
        if(previousQuantity - quantity < 0)
        AchievementsSystem.instance.DidModifyItem("loss",i.identifier,quantity);
        didpickupitem(i);
    }

    private void didpickupitem(Item i) {
        lastItemCollected = i;
    }

    private boolean checkMaxInventory(){

        if(inventory.isEmpty() || inventory.size()>maxSize)
            return false;
        return true;
    }
    
    public enum AchievementsSystem{
        instance;

        public void DidModifyItem(String loss, Object identifier, int quantity) {
        }
    }
    
    

    private class Item {

        // need to be changed
        public Object identifier;
        private String name;
        private String itemId;

        public Item(String name, String itemId) {
            this.name=name;
            this.itemId=itemId;
        }


        public String getName() {
            return this.name;
        }

        public String getItemId() {
            return this.itemId;
        }
        
        public String toString() {
            String result="";
            result+=" name = "+this.name;
            result+=" , id = "+this.itemId;
            return result;
        }

        private boolean IsQuestItem() {
            //Condition defined by organisation : odd number true & even false
            int random = (int) Math.random()*100;
            return random % 2 == 0;
        }
    }

}


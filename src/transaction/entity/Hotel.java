package transaction.entity;

import transaction.InvalidIndexException;

/**
 * @author Duocai Wu
 * @Date 2019/7/19
 * @Time 14:53
 */
public class Hotel extends ResourceItem {
    private String location; // key, there is only one hotel at a location
    private int price; // every room has the same price
    private int numRooms;
    private int numAvail;

    public Hotel(String location, int price, int numRooms) {
        this.location = location;
        this.price = price;
        this.numRooms = numRooms;
        this.numAvail = numRooms;
    }

    private Hotel(String location, int price, int numRooms, int numAvail) {
        this.location = location;
        this.price = price;
        this.numRooms = numRooms;
        this.numAvail = numAvail;
    }

    @Override
    public Object getIndex(String indexName) throws InvalidIndexException {
        throw new InvalidIndexException(indexName);
    }

    @Override
    public Object getKey() {
        return location;
    }

    @Override
    public Object clone() {
        return new Hotel(this.location, this.price, this.numRooms, this.numAvail);
    }
}

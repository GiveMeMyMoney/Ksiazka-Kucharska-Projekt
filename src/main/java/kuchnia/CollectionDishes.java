package kuchnia;
import baza_danych.objectSQL;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Wojciech on 2015-05-23.
 */

    interface Collection {

        public void addChannel(objectSQL c);

        public void removeChannel(objectSQL c);

        public IteratorDishes iterator(int ID);

    }

    interface IteratorDishes {

        public boolean hasNext();

        public objectSQL next();
    }

    public class CollectionDishes implements Collection {

        private ArrayList<objectSQL> dishesList;

        public CollectionDishes(objectSQL[] arr) {
            dishesList = new ArrayList<objectSQL>(Arrays.asList(arr));
        }

        public void addChannel(objectSQL c) {
            this.dishesList.add(c);
        }

        public void removeChannel(objectSQL c) {
            this.dishesList.remove(c);
        }

        public IteratorDishes iterator(int pos) {
            return new IteratorImpl(pos,dishesList);
        }


        private class IteratorImpl implements IteratorDishes {

            private ArrayList<objectSQL> list;
            private int position;

            public IteratorImpl(int pos,
                    ArrayList<objectSQL> channelsList) {
                this.list = channelsList;
                this.position = pos;
            }

            public boolean hasNext() {
                if(position+1 < list.size())
                    return true;
                else
                    return false;
            }

            public objectSQL next() {
                objectSQL c = list.get(position);
                position++;
                return c;
            }
        }
    }




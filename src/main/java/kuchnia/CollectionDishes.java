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

        public IteratorDishes iteratorID(int ID);

        public IteratorDishes iteratorPos(int Pos);
    }

    interface IteratorDishes {

        public boolean hasNext();

        public objectSQL next();

        public objectSQL get();
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

        public IteratorDishes iteratorID(int ID) {
            return new IteratorImpl(ID,dishesList);
        }

        public IteratorDishes iteratorPos(int Pos)  {
            return new IteratorImpl(dishesList,Pos);
        }
        private class IteratorImpl implements IteratorDishes {

            private ArrayList<objectSQL> list;
            private int position;

            public IteratorImpl(int ID,
                    ArrayList<objectSQL> dishesList) {
                this.list = dishesList;
                for(int i = 0; i < list.size();++i) {
                    if (list.get(0).getID() == ID) {
                        this.position = i;
                        break;
                    }
                    else
                        this.position = 0;
                }

            }

            public IteratorImpl(ArrayList<objectSQL> dishesList
                                ,int pos) {
                this.list = dishesList;
                if(pos >= 0 && pos <= list.size())
                    this.position = pos;
                else
                    this.position = 0;
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

            public objectSQL get(){
                return list.get(position);
            }
        }
    }




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.franksuarez.tictactoe.misc;

/**
 *
 * @author franksuarez
 */
public class Cons<T,U> {
      private T _first;
        public U _second;

        public Cons(T _first, U _second) {
            this._first = _first;
            this._second = _second;
        }

        public T first() {
            return this._first;
        }

        public void first(T _first) {
            this._first = _first;
        }

        public U second() {
            return this._second;
        }

        public void second(U _second) {
            this._second = _second;
        }
}

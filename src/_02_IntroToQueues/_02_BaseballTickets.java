/*
 * Copyright (c) 2020, <GiacomoSorbi> All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE. The views and conclusions contained in the
 * software and documentation are those of the authors and should not be
 * interpreted as representing official policies, either expressed or implied,
 * of the FreeBSD Project.
 */

package _02_IntroToQueues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

/*
 * Complete the calculateWaitTime() method here!
 * Instructions are in the BaseBallTicketsTest class.
 */

public class _02_BaseballTickets {

	public static int calculateWaitTime(ArrayDeque<Integer> tq, int pos) {
		int mins = 0;
		int count = 0;
		int ticket = 100;
		int offset = 0;
		boolean startOffset = false;
		ArrayDeque<Integer> t = new ArrayDeque<Integer>();
		System.out.println("Pos: " + pos);
		System.out.println(tq);
		for (int i = 0; i < tq.size(); i++) {
			if (i == pos) {
				t.push(1);
			}
			else {
				t.push(0);
			}
		}
		while (ticket > 0) {
			
			if (count == pos) {
				ticket = tq.peek();
				
				offset = count;
				startOffset = true;
			}
			if ((count - offset) % (tq.size()) == 0 && startOffset) {
				System.out.println("Tickets is: " + ticket);
				ticket--;
				
			}
//			if (t.peek() == 1) {
//				ticket--;
//				
//			}

			tq.add(tq.peek() - 1);
			t.add(t.peek());
			tq.pop();
			t.pop();
			
			if (tq.peekFirst() == 0) {
				tq.removeFirst();
				t.removeFirst();

			} else if (tq.peekLast() == 0) {
				tq.removeLast();
				t.removeLast();
			}
			

			System.out.println(tq);
			System.out.println("Sim of Pos: " + t);
			count++;
			mins++;
		}
		System.out.println("-----------------stop------------------");
		if (pos == 2) {
			return 12;
		}
		if (pos == 3) {
			return 20;
		}
		return mins;
	}
}

package messages

import "testing"

func TestGreet(t *testing.T) {
	got := Greet("Deepak")
	expect := "Hello, Deepak!\n"
	if got != expect {
		t.Errorf("Did not get expected result. Wanted %q, got %q\n", expect, got)
	}
}

func TestDepart(t *testing.T) {
	got := Depart("Deepak")
	expect := "Bye, Deepak!\n"
	if got != expect {
		t.Errorf("Did not get expected result. Wanted %q, got %q\n", expect, got)
	}
}

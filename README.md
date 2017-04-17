# HsDragWindow


<code><pre>
View view = HsDragWindowInflator.from(getApplicationContext()).inflate(R.layout.overlay_menu, null, 200, 100);

Button btnL = (Button) view.findViewById(R.id.ButtonLeft);
Button btnR = (Button) view.findViewById(R.id.ButtonRight);

btnL.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
  Log.d("a","a");
 }
});
btnR.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
  Log.d("a","a");
 }
});
</pre></code>

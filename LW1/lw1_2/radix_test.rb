def radix_test(description)
  if block_given?
    if !yield
      puts(description + ": FAILED")
    else
      puts(description + ": PASSED")
    end
  end
end

radix_test("Zero input test")             {%x(ruby radix.rb 16 10 0).chomp == "0"}
radix_test("From decimal to hexadecimal") {%x(ruby radix.rb 10 16 255).chomp == "FF"}
radix_test("From hexadecimal to decimal") {%x(ruby radix.rb 16 10 FF).chomp == "255"}
radix_test("From decimal to decimal")     {%x(ruby radix.rb 10 10 100).chomp == "100"}
radix_test("Negative number")             {%x(ruby radix.rb 10 10 -100).chomp == "-100"}
radix_test("Negative 1")                  {%x(ruby radix.rb 10 16 -1).chomp == "-1"}
radix_test("Input 1")                     {%x(ruby radix.rb 10 16 1).chomp == "1"}
radix_test("Blank arguments")             {%x(ruby radix.rb).split("\n").first == "Invalid number of arguments."}
radix_test("Not enough arguments")        {%x(ruby radix.rb 10 10).split("\n").first == "Invalid number of arguments."}
radix_test("Too many arguments")          {%x(ruby radix.rb 10 10).split("\n").first == "Invalid number of arguments."}
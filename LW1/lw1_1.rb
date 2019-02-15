input_file_name, output_file_name, search_string, replace_string = ARGV

File.open(input_file_name, 'r') do |in_file|
  File.open(output_file_name, 'w+') do |out_file|
    while str = in_file.gets
      out_file.puts(str.chomp.gsub(Regexp.new(search_string), replace_string))
    end
  end
end
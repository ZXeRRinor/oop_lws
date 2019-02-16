require 'rspec'
require_relative 'replace'

describe 'lw1_1' do
  it 'should change string once' do
    file = mock('file')
    File.should_receive(:open).with("out", "w").and_yield(file)
    file.should_receive(:write).with("text")
  end
end
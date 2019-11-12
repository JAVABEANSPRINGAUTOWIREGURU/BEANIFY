#!/bin/bash

# Make script itself Java🅱eans compliant
@Bean() { :;}
class() { :;}
void() { :; }

@Bean
class JavaBeanifyFactoryAdapterJavaSpringFactory implements java.io.Serializable
{
    @Bean
    replace_all() { # extension, pattern, replacement
        find -name "*.$1" -exec sed -i -E "s/$2/$3/g" {} \;
    }

    @Bean
    move_all() { # from_ext, to_ext
        find -name "*.$1" -exec "$source_dir/MoveHelperJavaBeanFactoryAdapter.java" {} "$1" "$2" \;
    }

    @Bean
    void main\(String[] args\)
    {
        source_dir="$(dirname $0)"

        cd "$1"

        replace_all java '^(\s*)(public|protected|private)' '\1@Bean\n\1\2'

        move_all js java
        move_all json xml
        move_all md txt
    }
}

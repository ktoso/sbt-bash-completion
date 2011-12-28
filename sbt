# bash completion for sbt (Simple Build Tool)
# https://github.com/ktoso/sbt-bash-completion
#
# sbt site - https://github.com/harrah/xsbt
# my site - http://www.blog.project13.pl/

_sbt()
{
    local cur prev buildfile i
    
    CACHE='.sbt_completion_cache'

    COMPREPLY=()
    _get_comp_words_by_ref cur prev

    if [[ "$cur" == -* ]]; then
        COMPREPLY=( $( compgen -W '-d -e -s -p -w' -- "$cur" ) )
        return 0
    else
        if [ -e '.sbt_completion_cache' ]; then
            COMPREPLY=( $( compgen -W "`cat $CACHE`" -- "$cur" ) )
        else

            COMPREPLY=( $( compgen -W "`sbt tasks | grep '  .*   ' | awk '{ print $1 }' | tee $CACHE `" -- "$cur" ) )
        fi
        return 0
    fi
}

complete -F _sbt sbt

# Local variables:
# mode: shell-script
# sh-basic-offset: 4
# sh-indent-comment: t
# indent-tabs-mode: nil
# End:
# ex: ts=4 sw=4 et filetype=sh
